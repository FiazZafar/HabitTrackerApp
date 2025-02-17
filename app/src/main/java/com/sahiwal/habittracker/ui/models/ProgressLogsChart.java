package com.sahiwal.habittracker.ui.models;

public class ProgressLogsChart {
    public ProgressLogsChart(float date, float progress) {
        this.date = date;
        this.progress = progress;
    }

    float date;
    float progress; // This could be time spent, percentage, etc.

    public float getDate() {
        return date;
    }

    public void setDate(float date) {
        this.date = date;
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
    }
}
