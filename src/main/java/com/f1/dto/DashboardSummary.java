package com.f1.dto;

public class DashboardSummary {

    private long totalDrivers;
    private long totalRaces;
    private long totalResults;

    public DashboardSummary(
            long totalDrivers,
            long totalRaces,
            long totalResults) {

        this.totalDrivers = totalDrivers;
        this.totalRaces = totalRaces;
        this.totalResults = totalResults;
    }

    public long getTotalDrivers() {
        return totalDrivers;
    }

    public long getTotalRaces() {
        return totalRaces;
    }

    public long getTotalResults() {
        return totalResults;
    }
}