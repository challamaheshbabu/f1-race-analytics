package com.f1.dto;

public class TeamStanding {

    private String team;
    private int totalPoints;

    public TeamStanding(String team, int totalPoints) {
        this.team = team;
        this.totalPoints = totalPoints;
    }

    public String getTeam() {
        return team;
    }

    public int getTotalPoints() {
        return totalPoints;
    }
}