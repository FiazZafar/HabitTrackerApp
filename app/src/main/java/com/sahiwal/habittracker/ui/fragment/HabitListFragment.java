package com.sahiwal.habittracker.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sahiwal.habittracker.R;
import com.sahiwal.habittracker.ui.adapters.HabitAdapter2;
import com.sahiwal.habittracker.ui.models.HabitModel;
import com.sahiwal.habittracker.ui.adapters.HabitAdapter;

import android.widget.Button;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class HabitListFragment extends Fragment {

    private RecyclerView recyclerHabitList;
    private Button btnAddHabit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_habit_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerHabitList = view.findViewById(R.id.recyclerViewHabits);
        btnAddHabit = view.findViewById(R.id.btn_add_habit);

        setupHabitListRecycler();
        setupAddHabitButton();
    }

    private void setupHabitListRecycler() {
        List<HabitModel> habitList = new ArrayList<>();
        habitList.add(new HabitModel("Health",80));
        habitList.add(new HabitModel("Exercise", 70));
        habitList.add(new HabitModel("Reading", 50));
        habitList.add(new HabitModel("Meditation", 80));
        habitList.add(new HabitModel("Learning", 60));

        HabitAdapter2 habitAdapter = new HabitAdapter2(getContext(),habitList);
        recyclerHabitList.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerHabitList.setAdapter(habitAdapter);
    }

    private void setupAddHabitButton() {
        btnAddHabit.setOnClickListener(v -> Toast.makeText(getContext(), "Add Habit clicked", Toast.LENGTH_SHORT).show());
    }



}
