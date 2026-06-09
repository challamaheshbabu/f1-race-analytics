package com.f1.dto;

public class RaceLeaderboardDTO {

    private int position;
    private String driverName;
    private String team;
    private int points;

    public RaceLeaderboardDTO(
            int position,
            String driverName,
            String team,
            int points) {

        this.position = position;
        this.driverName = driverName;
        this.team = team;
        this.points = points;
    }

    public int getPosition() {
        return position;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getTeam() {
        return team;
    }

    public int getPoints() {
        return points;
    }
}