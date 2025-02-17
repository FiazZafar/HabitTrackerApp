package com.sahiwal.habittracker.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.sahiwal.habittracker.R;
import com.sahiwal.habittracker.ui.models.ChartHabit;
import com.sahiwal.habittracker.ui.models.ProgressLogsChart;

import java.util.ArrayList;
import java.util.List;

public class HabitChartAdapter extends RecyclerView.Adapter<HabitChartAdapter.ChartViewHolder> {

    private Context context;
    private List<ChartHabit> chartList;

    public HabitChartAdapter(Context context, List<ChartHabit> chartList) {
        this.context = context;
        this.chartList = chartList;
    }

    @NonNull
    @Override
    public ChartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.habit_chart_list, parent, false);
        return new ChartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChartViewHolder holder, int position) {
        ChartHabit currentHabit = chartList.get(position);
        holder.bindData(currentHabit);
    }

    @Override
    public int getItemCount() {
        return chartList.size(); // Corrected to return the size of the list
    }

    public static class ChartViewHolder extends RecyclerView.ViewHolder {

        private LineChart habitChart;

        public ChartViewHolder(View view) {
            super(view);
            habitChart = itemView.findViewById(R.id.chart_habit_progress);  // Initialize the chart
        }

        public void bindData(ChartHabit habit) {
            List<Entry> entries = new ArrayList<>();
            for (ProgressLogsChart log : habit.getProgressLogs()) {
                entries.add(new Entry(log.getDate(),log.getProgress()));
            }

            LineDataSet dataSet = new LineDataSet(entries, habit.getHabitName());
            LineData lineData = new LineData(dataSet);
            habitChart.setData(lineData);
            habitChart.invalidate();  // Refresh the chart

            // Optional: Customize the chart (e.g., X-axis labels, colors)
            habitChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(getDateLabels(habit.getProgressLogs())));
            habitChart.getAxisLeft().setAxisMinimum(0f);
            habitChart.getAxisRight().setEnabled(false);
        }

        private List<String> getDateLabels(List<ProgressLogsChart> progressLogs) {
            List<String> labels = new ArrayList<>();
            for (ProgressLogsChart log : progressLogs) {
                labels.add(String.valueOf(log.getDate()));  // Add date for each log
            }
            return labels;
        }
    }
}
