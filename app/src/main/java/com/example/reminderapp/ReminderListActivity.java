package com.example.locationreminder;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.locationreminder.database.Reminder;
import com.example.locationreminder.database.ReminderDatabase;

import java.util.List;

import com.example.reminderapp.R;

public class ReminderListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder_list);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Reminder> reminders = ReminderDatabase.getInstance(this).reminderDao().getAll();
        ReminderAdapter adapter = new ReminderAdapter(reminders);
        recyclerView.setAdapter(adapter);
    }
}
