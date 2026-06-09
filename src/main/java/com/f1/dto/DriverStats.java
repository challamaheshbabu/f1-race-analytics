package com.f1.dto;

public class DriverStats {

    private String driverName;
    private int totalPoints;
    private int races;
    private int wins;
    private int podiums;

    public DriverStats(
            String driverName,
            int totalPoints,
            int races,
            int wins,
            int podiums) {

        this.driverName = driverName;
        this.totalPoints = totalPoints;
        this.races = races;
        this.wins = wins;
        this.podiums = podiums;
    }

    public String getDriverName() {
        return driverName;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public int getRaces() {
        return races;
    }

    public int getWins() {
        return wins;
    }

    public int getPodiums() {
        return podiums;
    }
}