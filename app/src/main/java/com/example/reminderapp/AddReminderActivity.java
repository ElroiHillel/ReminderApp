package com.example.locationreminder;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.locationreminder.database.Reminder;
import com.example.locationreminder.database.ReminderDatabase;
import com.example.reminderapp.R;

public class AddReminderActivity extends AppCompatActivity {
    private EditText edtLocation, edtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reminder);

        edtLocation = findViewById(R.id.edtLocation);
        edtContent = findViewById(R.id.edtContent);
        Button btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(this::saveReminder);
    }

    private void saveReminder(View view) {
        String location = edtLocation.getText().toString();
        String content = edtContent.getText().toString();

        if (location.isEmpty() || content.isEmpty()) {
            Toast.makeText(this, "יש למלא את כל השדות", Toast.LENGTH_SHORT).show();
            return;
        }

        Reminder reminder = new Reminder(location, content);
        ReminderDatabase.getInstance(this).reminderDao().insert(reminder);

        Toast.makeText(this, "התזכורת נשמרה", Toast.LENGTH_SHORT).show();
        finish();
    }
}
