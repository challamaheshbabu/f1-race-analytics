package com.f1.model;

import jakarta.persistence.*;

@Entity
public class RaceResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long driverId;
    private Long raceId;
    private int position;
    private int points;

    public RaceResult() {
    }

    public RaceResult(Long driverId, Long raceId, int position, int points) {
        this.driverId = driverId;
        this.raceId = raceId;
        this.position = position;
        this.points = points;
    }

    public Long getId() {
        return id;
    }

    public Long getDriverId() {
        return driverId;
    }

    public Long getRaceId() {
        return raceId;
    }

    public int getPosition() {
        return position;
    }

    public int getPoints() {
        return points;
    }
}