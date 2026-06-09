package com.f1.service;

import com.f1.dto.DriverStanding;
import com.f1.dto.TeamStanding;
import com.f1.model.Driver;
import com.f1.model.RaceResult;
import com.f1.repository.DriverRepository;
import com.f1.repository.RaceResultRepository;
import org.springframework.stereotype.Service;
import com.f1.dto.DriverStats;
import com.f1.dto.TeamChampionshipStanding;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DriverService {

    private final DriverRepository driverRepo;
    private final RaceResultRepository resultRepo;

    public DriverService(
            DriverRepository driverRepo,
            RaceResultRepository resultRepo) {

        this.driverRepo = driverRepo;
        this.resultRepo = resultRepo;
    }

    public List<Driver> getAllDrivers() {
        return driverRepo.findAll();
    }

    public Driver getDriverById(Long id) {
        return driverRepo.findById(id).orElse(null);
    }

    public Driver saveDriver(Driver driver) {
        return driverRepo.save(driver);
    }

    public List<Driver> getStandings() {
        return driverRepo.findAll()
                .stream()
                .sorted((a, b) ->
                        Integer.compare(b.getPoints(), a.getPoints()))
                .toList();
    }

    public List<TeamStanding> getTeamStandings() {

        return driverRepo.findAll()
                .stream()
                .collect(Collectors.groupingBy(
                        Driver::getTeam,
                        Collectors.summingInt(Driver::getPoints)
                ))
                .entrySet()
                .stream()
                .map(e -> new TeamStanding(
                        e.getKey(),
                        e.getValue()))
                .sorted((a, b) ->
                        Integer.compare(
                                b.getTotalPoints(),
                                a.getTotalPoints()))
                .toList();
    }

    public List<DriverStanding> getDriverStandings() {

        Map<Long, Integer> totals = new HashMap<>();

        for (RaceResult result : resultRepo.findAll()) {

            totals.merge(
                    result.getDriverId(),
                    result.getPoints(),
                    Integer::sum
            );
        }

        return totals.entrySet()
                .stream()
                .map(entry -> {

                    String driverName =
                            driverRepo.findById(entry.getKey())
                                    .orElseThrow()
                                    .getName();

                    return new DriverStanding(
                            driverName,
                            entry.getValue()
                    );
                })
                .sorted((a, b) ->
                        Integer.compare(
                                b.getPoints(),
                                a.getPoints()))
                .collect(Collectors.toList());
    }

    public DriverStats getDriverStats(Long driverId) {

    Driver driver = driverRepo.findById(driverId)
            .orElseThrow();

    List<RaceResult> results = resultRepo.findAll()
            .stream()
            .filter(r -> r.getDriverId().equals(driverId))
            .toList();

    int totalPoints = results.stream()
            .mapToInt(RaceResult::getPoints)
            .sum();

    int wins = (int) results.stream()
            .filter(r -> r.getPosition() == 1)
            .count();

    int podiums = (int) results.stream()
            .filter(r -> r.getPosition() <= 3)
            .count();

    return new DriverStats(
            driver.getName(),
            totalPoints,
            results.size(),
            wins,
            podiums
    );
}

public List<TeamChampionshipStanding> getChampionshipTeamStandings() {

    Map<String, Integer> teamPoints = new HashMap<>();

    for (RaceResult result : resultRepo.findAll()) {

        Driver driver = driverRepo
                .findById(result.getDriverId())
                .orElse(null);

        if (driver == null) {
            continue;
        }

        teamPoints.merge(
                driver.getTeam(),
                result.getPoints(),
                Integer::sum
        );
    }

    return teamPoints.entrySet()
            .stream()
            .map(entry -> new TeamChampionshipStanding(
                    entry.getKey(),
                    entry.getValue()
            ))
            .sorted((a, b) ->
                    Integer.compare(
                            b.getPoints(),
                            a.getPoints()))
            .toList();
}
}