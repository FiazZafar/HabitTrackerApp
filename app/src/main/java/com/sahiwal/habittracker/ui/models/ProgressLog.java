package com.sahiwal.habittracker.ui.models;

public class ProgressLog {
    private String date;
    private String details;

    public ProgressLog(String date, String details) {
        this.date = date;
        this.details = details;
    }

    public String getDate() {
        return date;
    }

    public String getDetails() {
        return details;
    }
}
