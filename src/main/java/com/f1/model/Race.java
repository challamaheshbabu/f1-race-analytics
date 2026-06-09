package com.f1.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String circuit;
    private LocalDate raceDate;

    public Race() {}

    public Race(String name, String circuit, LocalDate raceDate) {
        this.name = name;
        this.circuit = circuit;
        this.raceDate = raceDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCircuit() {
        return circuit;
    }

    public LocalDate getRaceDate() {
        return raceDate;
    }
}