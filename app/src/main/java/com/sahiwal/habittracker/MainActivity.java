package com.sahiwal.habittracker;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationBarView;
import com.sahiwal.habittracker.databinding.ActivityMainBinding;
import com.sahiwal.habittracker.ui.fragment.DashboardFragment;
import com.sahiwal.habittracker.ui.fragment.HabitDetailsFragment;
import com.sahiwal.habittracker.ui.fragment.HabitListFragment;
import com.sahiwal.habittracker.ui.fragment.ReminderFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        loadFragment(new DashboardFragment(),0);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        navView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int currentItem = item.getItemId();
                if (currentItem == R.id.navigation_home){
                    loadFragment(new HabitListFragment(),1);
                    Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();
                }else if(currentItem == R.id.navigation_dashboard){
                    loadFragment(new DashboardFragment(),1);
                    Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();
                } else if (currentItem == R.id.navigation_reminder) {
                    loadFragment(new ReminderFragment(),1);
                } else {
                    loadFragment(new HabitDetailsFragment(),1);
                }
                return true;
            }
        });

    }
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Habit Reminder Channel";
            String description = "Channel for Habit Reminders";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel("habit_channel", name, importance);
            channel.setDescription(description);
            NotificationManager manager = getSystemService(NotificationManager.class);
            if (manager != null) {
                manager.createNotificationChannel(channel);
            }
        }
    }

    private void loadFragment(Fragment fragment,int flag) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.nav_host_fragment_activity_main, fragment)
                .commit();
    }
}