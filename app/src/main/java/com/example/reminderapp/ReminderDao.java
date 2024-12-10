package com.example.locationreminder.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ReminderDao {
    @Insert
    void insert(Reminder reminder);

    @Query("SELECT * FROM Reminder")
    List<Reminder> getAll();
}
