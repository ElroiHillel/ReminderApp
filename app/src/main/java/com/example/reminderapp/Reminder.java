package com.example.locationreminder.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Reminder {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String location;
    private String content;

    // בנאי עם פרמטרים
    public Reminder(String location, String content) {
        this.location = location;
        this.content = content;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}
