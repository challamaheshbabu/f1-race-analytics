package com.f1.config;

import com.f1.model.Race;
import com.f1.repository.RaceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

// @Component
public class RaceSeeder implements CommandLineRunner {

    private final RaceRepository repo;

    public RaceSeeder(RaceRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) {

        if (repo.count() > 0) return;

        List<Race> races = List.of(
                new Race("Bahrain Grand Prix", "Bahrain", LocalDate.of(2026, 3, 2)),
                new Race("Monaco Grand Prix", "Monaco", LocalDate.of(2026, 5, 25)),
                new Race("British Grand Prix", "Silverstone", LocalDate.of(2026, 7, 6)),
                new Race("Singapore Grand Prix", "Marina Bay", LocalDate.of(2026, 9, 15))
        );

        repo.saveAll(races);

        System.out.println("🏁 F1 Races seeded successfully!");
    }
}