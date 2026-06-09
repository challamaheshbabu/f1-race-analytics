package com.f1.dto;

public class DriverStanding {

    private String driver;
    private int points;

    public DriverStanding(String driver, int points) {
        this.driver = driver;
        this.points = points;
    }

    public String getDriver() {
        return driver;
    }

    public int getPoints() {
        return points;
    }
}