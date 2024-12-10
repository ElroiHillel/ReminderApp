package com.example.locationreminder.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Reminder.class}, version = 1)
public abstract class ReminderDatabase extends RoomDatabase {
    private static ReminderDatabase instance;

    public static synchronized ReminderDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, ReminderDatabase.class, "reminder_db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries() // Avoid for large-scale apps
                    .build();
        }
        return instance;
    }

    public abstract ReminderDao reminderDao();
}
