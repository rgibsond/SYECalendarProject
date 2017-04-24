package com.sye.kupps.calendarapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.sye.kupps.calendarapp.containers.Event;

import java.util.List;

public class TimelineAdapter extends ArrayAdapter<Event> {

    private static final String LOG_TAG = TimelineAdapter.class.getName();

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

        Object tag = convertView.getTag();
        ViewHolder holder;
        if (tag == null) {

            holder = new ViewHolder();

            holder.title = ((TextView) convertView.findViewById(R.id.timeline_row_title));
            holder.createdBy = ((TextView) convertView.findViewById(R.id.timeline_row_creator));
            holder.createdOn = ((TextView) convertView.findViewById(R.id.timeline_row_created_date));
            holder.startDate = ((TextView) convertView.findViewById(R.id.timeline_row_start_date));
            holder.endDate = ((TextView) convertView.findViewById(R.id.timeline_row_end_date));
            holder.description = ((TextView) convertView.findViewById(R.id.timeline_row_description));

            convertView.setTag(holder);
            Log.i(LOG_TAG, "Created new ViewHolder");

        } else {
            Log.i(LOG_TAG, "We're reusing a ViewHolder");
            holder = (ViewHolder) tag;
        }

        holder.title.setText(event.getTitle());

        String createdBy = CREATED_BY + event.getCreator();
        holder.createdBy.setText(createdBy);

        String createdOn = CREATED_ON + event.getFormattedCreatedTime();
        holder.createdOn.setText(createdOn);

        holder.description.setText(event.getDescription());

        String endDate = END + event.getFormattedEndTime();
        holder.endDate.setText(endDate);

        String startDate = START + event.getFormattedStartTime();
        holder.startDate.setText(startDate);

        return convertView;
    }

    private static class ViewHolder {

        TextView title;
        TextView createdBy;
        TextView createdOn;
        TextView startDate;
        TextView endDate;
        TextView description;

    }

}
