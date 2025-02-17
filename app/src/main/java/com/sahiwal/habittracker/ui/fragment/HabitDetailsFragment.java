package com.sahiwal.habittracker.ui.fragment;

import static androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sahiwal.habittracker.R;
import com.sahiwal.habittracker.ui.adapters.HabitChartAdapter;
import com.sahiwal.habittracker.ui.models.ChartHabit;
import com.sahiwal.habittracker.ui.models.ProgressLogsChart;

import java.util.ArrayList;
import java.util.List;


public class HabitDetailsFragment extends Fragment {

    private RecyclerView recyclerView;
    private HabitChartAdapter adapter;
    private List<ChartHabit> chartHabitList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_habit_details, container, false);

        recyclerView = view.findViewById(R.id.recycler_view_habits);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize and set the adapter
        chartHabitList = getSampleData(); // Sample data or fetched from DB
        adapter = new HabitChartAdapter(getContext(), chartHabitList);
        recyclerView.setAdapter(adapter);

        return view;
    }

    // Sample data generation
    private List<ChartHabit> getSampleData() {
        List<ChartHabit> habits = new ArrayList<>();

        // Habit 1
        List<ProgressLogsChart> logs1 = new ArrayList<>();
        logs1.add(new ProgressLogsChart(1, 40));
        logs1.add(new ProgressLogsChart(2, 60));
        logs1.add(new ProgressLogsChart(3, 80));
        habits.add(new ChartHabit("Exercise", logs1));

        // Habit 2
        List<ProgressLogsChart> logs2 = new ArrayList<>();
        logs2.add(new ProgressLogsChart(1, 50));
        logs2.add(new ProgressLogsChart(2, 70));
        logs2.add(new ProgressLogsChart(3, 90));
        habits.add(new ChartHabit("Reading", logs2));

        // Habit 3
        List<ProgressLogsChart> logs3 = new ArrayList<>();
        logs3.add(new ProgressLogsChart(1, 50));
        logs3.add(new ProgressLogsChart(2, 70));
        logs3.add(new ProgressLogsChart(3, 90));
        habits.add(new ChartHabit("Reading", logs3));

        // Habit 4
        List<ProgressLogsChart> logs4= new ArrayList<>();
        logs4.add(new ProgressLogsChart(1, 50));
        logs4.add(new ProgressLogsChart(2, 70));
        logs4.add(new ProgressLogsChart(3, 90));
        habits.add(new ChartHabit("Reading", logs4));
        // Habit 5
        List<ProgressLogsChart> logs5 = new ArrayList<>();
        logs5.add(new ProgressLogsChart(1, 50));
        logs5.add(new ProgressLogsChart(2, 70));
        logs5.add(new ProgressLogsChart(3, 90));
        habits.add(new ChartHabit("Reading", logs5));
        return habits;
    }
}
