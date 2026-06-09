package com.f1.dto;

public class RaceResultResponse {

    private String driverName;
    private int position;
    private int points;

    public RaceResultResponse(String driverName, int position, int points) {
        this.driverName = driverName;
        this.position = position;
        this.points = points;
    }

    public String getDriverName() {
        return driverName;
    }

    public int getPosition() {
        return position;
    }

    public int getPoints() {
        return points;
    }
}