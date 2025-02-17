package com.sahiwal.habittracker.ui.fragment;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sahiwal.habittracker.R;
import com.sahiwal.habittracker.ui.ReminderReceiver;

import java.util.Calendar;

public class ReminderFragment extends Fragment {

    private EditText editTextHabitName, editTextTime;
    private Button buttonSetReminder;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reminder, container, false);

        editTextHabitName = view.findViewById(R.id.editTextHabitName);
        editTextTime = view.findViewById(R.id.editTextTime);
        buttonSetReminder = view.findViewById(R.id.buttonSetReminder);

        buttonSetReminder.setOnClickListener(v -> setReminder());

        return view;
    }

    private void setReminder() {
        String habitName = editTextHabitName.getText().toString().trim();
        String time = editTextTime.getText().toString().trim();

        if (habitName.isEmpty() || time.isEmpty()) {
            Toast.makeText(getContext(), "Please enter habit name and time", Toast.LENGTH_SHORT).show();
            return;
        }

        // Schedule reminder using AlarmManager
        scheduleReminder(habitName, time);
    }

    private void scheduleReminder(String habitName, String time) {
        AlarmManager alarmManager = (AlarmManager) requireContext().getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(requireContext(), ReminderReceiver.class);
        intent.putExtra("habitName", habitName);
//
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(requireContext(),
//                0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
// Use FLAG_IMMUTABLE unless you need to modify the PendingIntent later
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                requireContext(),
                0, // Unique request code
                intent,
                PendingIntent.FLAG_IMMUTABLE
        );

        String[] timeParts = time.split(":");
        Calendar myCalender = Calendar.getInstance();
        myCalender.set(Calendar.HOUR_OF_DAY,Integer.parseInt(timeParts[0]));
        myCalender.set(Calendar.MINUTE,Integer.parseInt(timeParts[1]));
        myCalender.set(Calendar.SECOND,Integer.parseInt(timeParts[0]));


        long triggerTime = System.currentTimeMillis()+myCalender.getTimeInMillis();
        if (alarmManager != null) {
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, triggerTime, pendingIntent);
            Toast.makeText(getContext(), "Reminder set for " + habitName, Toast.LENGTH_SHORT).show();
        }
    }
}