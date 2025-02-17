package com.sahiwal.habittracker.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.sahiwal.habittracker.R;
import com.sahiwal.habittracker.ui.fragment.HabitListFragment;
import com.sahiwal.habittracker.ui.models.HabitModel;

import java.util.List;

public class HabitAdapter2 extends RecyclerView.Adapter<HabitAdapter.HabitViewHolder> {
    private List<HabitModel> habitList;
    private Context context;

    public HabitAdapter2(HabitListFragment context, List<HabitModel> habitList) {
        this.context = context;
        this.habitList = habitList;
    }

    @Override
    public HabitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_habit, parent, false);
        return new HabitViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HabitViewHolder holder, int position) {
        HabitModel habit = habitList.get(position);
        holder.textHabitName.setText(habit.getName());


        holder.buttonEditHabit.setOnClickListener(v ->{

        });

        holder.buttonDeleteHabit.setOnClickListener(v -> {
            // Handle delete functionality (remove from database and update RecyclerView)
            habitList.remove(position);
            notifyItemRemoved(position);
        });
    }

    @Override
    public int getItemCount() {
        return habitList.size();
    }

    public static class HabitViewHolder extends RecyclerView.ViewHolder {
        TextView textHabitName;
        ImageButton buttonEditHabit;
        ImageButton buttonDeleteHabit;

        public HabitViewHolder(View itemView) {
            super(itemView);
            textHabitName = itemView.findViewById(R.id.text_habit_name);
            buttonEditHabit = itemView.findViewById(R.id.button_edit_habit);
            buttonDeleteHabit = itemView.findViewById(R.id.button_delete_habit);
        }
    }
}

