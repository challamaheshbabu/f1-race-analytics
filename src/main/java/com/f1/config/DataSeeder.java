package com.f1.config;

import com.f1.model.Driver;
import com.f1.model.Race;
import com.f1.model.RaceResult;
import com.f1.repository.DriverRepository;
import com.f1.repository.RaceRepository;
import com.f1.repository.RaceResultRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final DriverRepository driverRepo;
    private final RaceRepository raceRepo;
    private final RaceResultRepository resultRepo;

    public DataSeeder(DriverRepository driverRepo,
                      RaceRepository raceRepo,
                      RaceResultRepository resultRepo) {
        this.driverRepo = driverRepo;
        this.raceRepo = raceRepo;
        this.resultRepo = resultRepo;
    }

    @Override
    public void run(String... args) {

        System.out.println("Driver count = " + driverRepo.count());
        System.out.println("Race count = " + raceRepo.count());
        System.out.println("Result count = " + resultRepo.count());

    // Seed Drivers
    if (driverRepo.count() == 0) {

        List<Driver> drivers = List.of(
            new Driver("Max Verstappen", "Red Bull", 310),
            new Driver("Lewis Hamilton", "Mercedes", 250),
            new Driver("Charles Leclerc", "Ferrari", 220),
            new Driver("Lando Norris", "McLaren", 200),
            new Driver("Carlos Sainz", "Ferrari", 180),
            new Driver("Sergio Perez", "Red Bull", 175),
            new Driver("George Russell", "Mercedes", 160)
        );

        driverRepo.saveAll(drivers);
        System.out.println("✅ Drivers seeded");
    }

    // Seed Races
    if (raceRepo.count() == 0) {

        List<Race> races = List.of(
            new Race("Bahrain GP", "Bahrain", java.time.LocalDate.of(2025, 3, 2)),
            new Race("Saudi Arabia GP", "Jeddah", java.time.LocalDate.of(2025, 3, 9))
        );

        raceRepo.saveAll(races);
        System.out.println("✅ Races seeded");
    }

    // Seed Race Results
    if (resultRepo.count() == 0) {

        resultRepo.saveAll(List.of(
            new RaceResult(1L, 1L, 1, 25),
            new RaceResult(2L, 1L, 2, 18),
            new RaceResult(3L, 1L, 3, 15),

            new RaceResult(1L, 2L, 1, 25),
            new RaceResult(4L, 2L, 2, 18),
            new RaceResult(2L, 2L, 3, 15)
        ));

        System.out.println("✅ Race Results seeded");
    }

    }
}