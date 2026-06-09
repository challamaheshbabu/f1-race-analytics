package com.f1.service;

import com.f1.dto.DashboardSummary;
import com.f1.repository.DriverRepository;
import com.f1.repository.RaceRepository;
import com.f1.repository.RaceResultRepository;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    private final DriverRepository driverRepo;
    private final RaceRepository raceRepo;
    private final RaceResultRepository resultRepo;

    public DashboardService(
            DriverRepository driverRepo,
            RaceRepository raceRepo,
            RaceResultRepository resultRepo) {

        this.driverRepo = driverRepo;
        this.raceRepo = raceRepo;
        this.resultRepo = resultRepo;
    }

    public DashboardSummary getSummary() {

        return new DashboardSummary(
                driverRepo.count(),
                raceRepo.count(),
                resultRepo.count()
        );
    }
}