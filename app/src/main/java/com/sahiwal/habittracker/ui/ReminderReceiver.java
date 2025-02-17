package com.sahiwal.habittracker.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.provider.Settings;
import android.widget.Toast;

public class ReminderReceiver extends BroadcastReceiver {
MediaPlayer mp ;
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Reminder Triggered", Toast.LENGTH_SHORT).show();  // Debugging Toast
        mp = MediaPlayer.create(context, Settings.System.DEFAULT_ALARM_ALERT_URI);
        mp.setLooping(true);
        mp.start();
    }

}
