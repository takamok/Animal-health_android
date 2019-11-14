package com.example.animal_health;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ReminderList extends ArrayAdapter<Reminder> {
    private Activity context;
    List<Reminder> artists;

    public ReminderList(Activity context, List<Reminder> artists) {
        super(context, R.layout.layout_reminder_list, artists);
        this.context = context;
        this.artists = artists;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_reminder_list, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewGenre = (TextView) listViewItem.findViewById(R.id.textViewGenre);
        TextView textViewTime = (TextView) listViewItem.findViewById(R.id.textViewTime);

        Reminder artist = artists.get(position);
        textViewName.setText(artist.getreminderName());
        textViewGenre.setText(artist.getreminderDate());
        textViewTime.setText(artist.getreminderTime());

        return listViewItem;
    }
}