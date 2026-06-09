package com.f1.service;

import com.f1.dto.RaceResultResponse;
import com.f1.model.RaceResult;
import com.f1.repository.DriverRepository;
import com.f1.repository.RaceResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceResultService {

    private final RaceResultRepository resultRepo;
    private final DriverRepository driverRepo;

    public RaceResultService(
            RaceResultRepository resultRepo,
            DriverRepository driverRepo) {

        this.resultRepo = resultRepo;
        this.driverRepo = driverRepo;
    }

    public List<RaceResult> getAllResults() {
        return resultRepo.findAll();
    }

    public List<RaceResult> getResultsByRace(Long raceId) {
        return resultRepo.findByRaceId(raceId);
    }

    public List<RaceResultResponse> getRaceResultsWithDriverNames(Long raceId) {

        return resultRepo.findByRaceId(raceId)
                .stream()
                .map(result -> {

                    String driverName = driverRepo
                            .findById(result.getDriverId())
                            .orElseThrow()
                            .getName();

                    return new RaceResultResponse(
                            driverName,
                            result.getPosition(),
                            result.getPoints()
                    );
                })
                .toList();
    }
}