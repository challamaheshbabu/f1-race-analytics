package com.f1.controller;

import com.f1.dto.DriverStanding;
import com.f1.dto.TeamStanding;
import com.f1.model.Driver;
import com.f1.service.DriverService;
import org.springframework.web.bind.annotation.*;
import com.f1.dto.DriverStats;
import com.f1.dto.TeamChampionshipStanding;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping
    public List<Driver> getAllDrivers() {
        return driverService.getAllDrivers();
    }

    @GetMapping("/{id}")
    public Driver getDriver(@PathVariable Long id) {
        return driverService.getDriverById(id);
    }

    @PostMapping
    public Driver addDriver(@RequestBody Driver driver) {
        return driverService.saveDriver(driver);
    }

    // Original driver table standings
    @GetMapping("/points")
    public List<Driver> getStandings() {
        return driverService.getStandings();
    }

    // Team standings
    @GetMapping("/teams")
    public List<TeamStanding> getTeamStandings() {
        return driverService.getTeamStandings();
    }

    // Race-result-based standings
    @GetMapping("/standings")
    public List<DriverStanding> standings() {
        return driverService.getDriverStandings();
    }

    @GetMapping("/{id}/stats")
    public DriverStats getDriverStats(

    @PathVariable Long id) {
    return driverService.getDriverStats(id);
}
@GetMapping("/championship/teams")
public List<TeamChampionshipStanding> championshipTeams() {
    return driverService.getChampionshipTeamStandings();
}
}