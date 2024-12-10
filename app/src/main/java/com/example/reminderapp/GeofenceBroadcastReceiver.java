package com.example.locationreminder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;

import java.util.List;

public class GeofenceBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "GeofenceBroadcastReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        GeofencingEvent event = GeofencingEvent.fromIntent(intent);

        if (event.hasError()) {
            Log.e(TAG, "Geofencing error: " + event.getErrorCode());
            return;
        }

        List<Geofence> triggeringGeofences = event.getTriggeringGeofences();
        int transitionType = event.getGeofenceTransition();

        for (Geofence geofence : triggeringGeofences) {
            String geofenceId = geofence.getRequestId();
            if (transitionType == Geofence.GEOFENCE_TRANSITION_ENTER) {
                Log.d(TAG, "Entered geofence: " + geofenceId);
            } else if (transitionType == Geofence.GEOFENCE_TRANSITION_EXIT) {
                Log.d(TAG, "Exited geofence: " + geofenceId);
            }
        }
    }
}
