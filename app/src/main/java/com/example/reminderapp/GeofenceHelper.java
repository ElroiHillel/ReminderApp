package com.example.locationreminder;

import android.content.Context;
import android.util.Log;

import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingClient;
import com.google.android.gms.location.GeofencingRequest;
//import com.google.android.gms.location.PendingIntent;
import android.app.PendingIntent;

import java.util.Collections;

import android.content.Intent;

public class GeofenceHelper {
    private static final String TAG = "GeofenceHelper";
    private Context context;
    private GeofencingClient geofencingClient;
    private PendingIntent geofencePendingIntent;

    public GeofenceHelper(Context context, GeofencingClient geofencingClient) {
        this.context = context;
        this.geofencingClient = geofencingClient;
    }

    public void addGeofence(String geofenceId, double latitude, double longitude, float radius) {
        Geofence geofence = new Geofence.Builder()
                .setRequestId(geofenceId)
                .setCircularRegion(latitude, longitude, radius)
                .setExpirationDuration(Geofence.NEVER_EXPIRE)
                .setTransitionTypes(Geofence.GEOFENCE_TRANSITION_ENTER | Geofence.GEOFENCE_TRANSITION_EXIT)
                .build();

        GeofencingRequest request = new GeofencingRequest.Builder()
                .setInitialTrigger(GeofencingRequest.INITIAL_TRIGGER_ENTER)
                .addGeofence(geofence)
                .build();

        geofencingClient.addGeofences(request, getGeofencePendingIntent())
                .addOnSuccessListener(aVoid -> Log.d(TAG, "Geofence added successfully"))
                .addOnFailureListener(e -> Log.e(TAG, "Failed to add geofence", e));
    }

    private PendingIntent getGeofencePendingIntent() {
        if (geofencePendingIntent != null) {
            return geofencePendingIntent;
        }

        Intent intent = new Intent(context, GeofenceBroadcastReceiver.class);
        geofencePendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        return geofencePendingIntent;
    }
}
