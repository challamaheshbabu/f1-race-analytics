package com.f1.controller;

import com.f1.dto.RaceResultResponse;
import com.f1.model.RaceResult;
import com.f1.service.RaceResultService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/results")
public class RaceResultController {

    private final RaceResultService raceResultService;

    public RaceResultController(RaceResultService raceResultService) {
        this.raceResultService = raceResultService;
    }

    @GetMapping
    public List<RaceResult> getAllResults() {
        return raceResultService.getAllResults();
    }

    @GetMapping("/race/{raceId}")
    public List<RaceResult> getResultsByRace(
            @PathVariable Long raceId) {

        return raceResultService.getResultsByRace(raceId);
    }

    @GetMapping("/race/{raceId}/details")
    public List<RaceResultResponse> getRaceDetails(
            @PathVariable Long raceId) {

        return raceResultService
                .getRaceResultsWithDriverNames(raceId);
    }
}