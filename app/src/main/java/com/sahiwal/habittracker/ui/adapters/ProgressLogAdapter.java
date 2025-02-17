package com.sahiwal.habittracker.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.sahiwal.habittracker.R;
import com.sahiwal.habittracker.ui.models.ProgressLog;

import java.util.List;

public class ProgressLogAdapter extends RecyclerView.Adapter<ProgressLogAdapter.ProgressLogViewHolder> {
    private Context context;
    private List<ProgressLog> logList;

    public ProgressLogAdapter(Context context, List<ProgressLog> logList) {
        this.context = context;
        this.logList = logList;
    }

    @Override
    public ProgressLogViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_progress_log, parent, false);
        return new ProgressLogViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProgressLogViewHolder holder, int position) {
        ProgressLog log = logList.get(position);
        holder.dateTextView.setText(log.getDate());
        holder.detailsTextView.setText(log.getDetails());
    }

    @Override
    public int getItemCount() {
        return logList.size();
    }

    public static class ProgressLogViewHolder extends RecyclerView.ViewHolder {
        TextView dateTextView;
        TextView detailsTextView;

        public ProgressLogViewHolder(View itemView) {
            super(itemView);
            dateTextView = itemView.findViewById(R.id.text_log_date);
            detailsTextView = itemView.findViewById(R.id.text_log_details);
        }
    }
}
