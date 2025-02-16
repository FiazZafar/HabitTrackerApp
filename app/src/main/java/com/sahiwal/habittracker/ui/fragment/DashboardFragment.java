package com.sahiwal.habittracker.ui.fragment;


import static androidx.core.app.NotificationCompat.getColor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sahiwal.habittracker.R;
import com.sahiwal.habittracker.ui.adapters.HabitAdapter;
import com.sahiwal.habittracker.ui.adapters.ReminderAdapter;

import android.widget.Button;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;


public class DashboardFragment extends Fragment {

    private RecyclerView recyclerHabitOverview;
    private RecyclerView recyclerReminders;
    private FloatingActionButton btnAddHabit;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        recyclerHabitOverview = view.findViewById(R.id.recycler_habit_overview);
        recyclerReminders = view.findViewById(R.id.recycler_reminders);
        btnAddHabit = view.findViewById(R.id.btn_add_habit);

        setupProgressChart(view);


        setupHabitOverviewRecycler();
        setupRemindersRecycler();
        setupAddHabitButton();
    return view;
    }

    private void setupHabitOverviewRecycler() {
        List<String> habitList = new ArrayList<>();
        habitList.add("Exercise");
        habitList.add("Reading");
        habitList.add("Meditation");
        habitList.add("Learning");

        HabitAdapter habitAdapter = new HabitAdapter(habitList);
        recyclerHabitOverview.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerHabitOverview.setAdapter(habitAdapter);
    }

    private void setupRemindersRecycler() {
        List<String> reminders = new ArrayList<>();
        reminders.add("Drink water at 10 AM");
        reminders.add("Read book at 7 PM");
        reminders.add("Meditate at 6 AM");

        ReminderAdapter reminderAdapter = new ReminderAdapter(reminders);
        recyclerReminders.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerReminders.setAdapter(reminderAdapter);
    }

    private void setupAddHabitButton() {
        btnAddHabit.setOnClickListener(v -> Toast.makeText(getContext(), "Add Habit clicked", Toast.LENGTH_SHORT).show());
    }

    private static void setupProgressChart(View view) {
        BarChart barChart = view.findViewById(R.id.progress_chart_placeholder);
        ArrayList<BarEntry> entries = new ArrayList<>();

        // Sample data
        entries.add(new BarEntry(1, 5));
        entries.add(new BarEntry(3, 7));
        entries.add(new BarEntry(2, 6));
        entries.add(new BarEntry(4, 5));
        entries.add(new BarEntry(8, 4));
        entries.add(new BarEntry(2, 3));
        entries.add(new BarEntry(3, 5));
        entries.add(new BarEntry(4, 8));
        entries.add(new BarEntry(5, 6));

        BarDataSet dataSet = new BarDataSet(entries, "Progress Data");
        dataSet.setColor(R.color.primary_color);
        BarData barData = new BarData(dataSet);

        barChart.setData(barData);
        barChart.invalidate(); // Refresh chart
    }

}
