package com.example.locationreminder;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.GeofencingClient;
import com.google.android.gms.location.LocationServices;

import com.example.reminderapp.R;
public class MainActivity extends AppCompatActivity {
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    private GeofencingClient geofencingClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // בקשת הרשאות מיקום
        requestLocationPermissions();

        // הגדרת GeofencingClient
        geofencingClient = LocationServices.getGeofencingClient(this);

        Button btnAddReminder = findViewById(R.id.btnAddReminder);
        Button btnViewReminders = findViewById(R.id.btnViewReminders);

        btnAddReminder.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddReminderActivity.class);
            startActivity(intent);
        });

        btnViewReminders.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ReminderListActivity.class);
            startActivity(intent);
        });
    }

    private void requestLocationPermissions() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_BACKGROUND_LOCATION},
                LOCATION_PERMISSION_REQUEST_CODE);
    }

    // הוספת פונקציה לניהול Geofence (קריאה למחלקת עזר)
    public void addGeofence(String geofenceId, double latitude, double longitude, float radius) {
        GeofenceHelper geofenceHelper = new GeofenceHelper(this, geofencingClient);
        geofenceHelper.addGeofence(geofenceId, latitude, longitude, radius);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // הוספת הודעה למשתמש
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            Toast.makeText(this, "Permissions granted!", Toast.LENGTH_SHORT).show();
        }
    }
}
