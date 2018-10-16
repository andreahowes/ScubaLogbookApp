package com.andreahowes.dive_db.logic;

import java.time.LocalDate;

public class Dive {
    private int id;
    private LocalDate date;
    private String location;
    private int duration;
    private int maxDepth;
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

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
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

    public int getDuration() {
        return duration;
    }

    public int getMaxDepth() {
        return maxDepth;
    }

    public String getWaterConditions() {
        return waterConditions;
    }

    public boolean isSafetyStop() {
        return safetyStop;
    }
}
