package com.sahiwal.habittracker.ui.models;

import java.util.List;

public class ChartHabit {
    String habitName;

    public ChartHabit(String habitName, List<ProgressLogsChart> progressLogs) {
        this.habitName = habitName;
        this.progressLogs = progressLogs;
    }

    List<ProgressLogsChart> progressLogs;

    public String getHabitName() {
        return habitName;
    }

    public void setHabitName(String habitName) {
        this.habitName = habitName;
    }

    public List<ProgressLogsChart> getProgressLogs() {
        return progressLogs;
    }

    public void setProgressLogs(List<ProgressLogsChart> progressLogs) {
        this.progressLogs = progressLogs;
    }

    // Constructor, Getters, and Setters
}

