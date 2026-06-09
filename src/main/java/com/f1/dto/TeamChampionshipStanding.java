package com.f1.dto;

public class TeamChampionshipStanding {

    private String team;
    private int points;

    public TeamChampionshipStanding(String team, int points) {
        this.team = team;
        this.points = points;
    }

    public String getTeam() {
        return team;
    }

    public int getPoints() {
        return points;
    }
}