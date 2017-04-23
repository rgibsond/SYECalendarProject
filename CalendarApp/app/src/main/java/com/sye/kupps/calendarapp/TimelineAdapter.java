package com.sye.kupps.calendarapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.sye.kupps.calendarapp.containers.Event;

import java.util.List;

public class TimelineAdapter extends ArrayAdapter<Event> {

    private static final String CREATED_BY = "Created by: ";
    private static final String CREATED_ON = "Created on: ";
    private static final String START = "Starts: ";
    private static final String END = "Ends: ";

    public TimelineAdapter(Context context, int resource, List<Event> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView =
                    LayoutInflater.from(getContext()).inflate(R.layout.timeline_row, parent, false);

        Event event = getItem(position);

        ((TextView) convertView.findViewById(R.id.timeline_row_title)).setText(event.getTitle());

        String createdBy = CREATED_BY + event.getCreator();
        ((TextView) convertView.findViewById(R.id.timeline_row_creator)).setText(createdBy);

        String createdOn = CREATED_ON + event.getFormattedCreatedTime();
        ((TextView) convertView.findViewById(R.id.timeline_row_created_date)).setText(createdOn);

        String startDate = START + event.getFormattedStartTime();
        ((TextView) convertView.findViewById(R.id.timeline_row_start_date)).setText(startDate);

        String endDate = END + event.getFormattedEndTime();
        ((TextView) convertView.findViewById(R.id.timeline_row_end_date)).setText(endDate);

        ((TextView) convertView.findViewById(R.id.timeline_row_description)).setText(event.getDescription());

        return convertView;
    }

}
