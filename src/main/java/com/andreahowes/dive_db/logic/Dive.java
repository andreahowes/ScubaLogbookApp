package com.andreahowes.dive_db.logic;

import java.time.LocalDate;

public class Dive {
    private int id;
    private LocalDate date;
    private String location;
    private double durationInMinutes;
    private double maxDepthInMeters;
    private String waterConditions;
    private boolean safetyStop;

    public Dive() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDurationInMinutes(double durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public void setMaxDepthInMeters(double maxDepthInMeters) {
        this.maxDepthInMeters = maxDepthInMeters;
    }

    public void setWaterConditions(String waterConditions) {
        this.waterConditions = waterConditions;
    }

    public void setSafetyStop(boolean safetyStop) {
        this.safetyStop = safetyStop;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public double getDurationInMinutes() {
        return durationInMinutes;
    }

    public double getMaxDepthInMeters() {
        return maxDepthInMeters;
    }

    public String getWaterConditions() {
        return waterConditions;
    }

    public boolean getSafetyStop() {
        return safetyStop;
    }
}
