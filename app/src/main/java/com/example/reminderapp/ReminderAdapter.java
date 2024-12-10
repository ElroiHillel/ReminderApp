package com.example.locationreminder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.locationreminder.database.Reminder;

import java.util.List;

import com.example.reminderapp.R;

public class ReminderAdapter extends RecyclerView.Adapter<ReminderAdapter.ReminderViewHolder> {
    private final List<Reminder> reminders;

    public ReminderAdapter(List<Reminder> reminders) {
        this.reminders = reminders;
    }

    @NonNull
    @Override
    public ReminderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_reminder, parent, false);
        return new ReminderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReminderViewHolder holder, int position) {
        Reminder reminder = reminders.get(position);
        holder.txtLocation.setText(reminder.getLocation());
        holder.txtContent.setText(reminder.getContent());
    }

    @Override
    public int getItemCount() {
        return reminders.size();
    }

    public static class ReminderViewHolder extends RecyclerView.ViewHolder {
        TextView txtLocation, txtContent;

        public ReminderViewHolder(@NonNull View itemView) {
            super(itemView);
            txtLocation = itemView.findViewById(R.id.txtLocation);
            txtContent = itemView.findViewById(R.id.txtContent);
        }
    }
}
