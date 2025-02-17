package com.sahiwal.habittracker.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.sahiwal.habittracker.R;
import com.sahiwal.habittracker.ui.models.ProgressLog;

import java.util.ArrayList;
import java.util.List;

public class HabitDetailsFragment extends Fragment {

    HabitDetailsFragment(){

    }
    // Inside HabitDetailsFragment.java
    LineChart progressChart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_habit_details, container, false);

        // Initialize views
        progressChart = view.findViewById(R.id.progressChart);
        RecyclerView recyclerViewLogs = view.findViewById(R.id.recyclerViewLogs);

        // Setup the chart (example for LineChart)
        setupChart();

        // Setup the RecyclerView for progress logs
        setupLogsRecyclerView(recyclerViewLogs);

        return view;
    }

    private void setupChart() {
        // Sample data for chart (could be replaced with real data)
        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(1, 10f)); // Day 1, 10% progress
        entries.add(new Entry(2, 20f)); // Day 2, 20% progress

        LineDataSet dataSet = new LineDataSet(entries, "Habit Progress");
        dataSet.setColor(Color.BLUE);
        dataSet.setValueTextColor(Color.BLACK);

        LineData lineData = new LineData(dataSet);
        progressChart.setData(lineData);
        progressChart.invalidate(); // Refresh the chart
    }

    private void setupLogsRecyclerView(RecyclerView recyclerViewLogs) {
        // Setup adapter and RecyclerView for progress logs
        recyclerViewLogs.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewLogs.setAdapter(new ProgressLogAdapter(getContext(), getLogsData()));
    }

    private List<ProgressLog> getLogsData() {
        // Replace with real log data
        List<ProgressLog> logs = new ArrayList<>();
        logs.add(new ProgressLog("2025-02-15", "Completed 10 minutes"));
        logs.add(new ProgressLog("2025-02-16", "Completed 15 minutes"));
        return logs;
    }

}