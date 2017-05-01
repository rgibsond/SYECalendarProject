package com.sye.kupps.calendarapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.sye.kupps.calendarapp.R;
import com.sye.kupps.calendarapp.containers.Event;

import java.util.List;

/**
 * Created by kupps on 4/24/17.
 */

public class ProfileEventAdapter extends ArrayAdapter<Event> {

    private String username;

    private static final String CREATED_BY = "Created by: ";
    private static final String CREATED_ON = "Created on: ";
    private static final String START = "Starts: ";
    private static final String END = "Ends: ";
    private static final String STATUS = "Status: ";

    public ProfileEventAdapter(Context context, int resource, List<Event> objects) {
        super(context, resource, objects);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView =
                    LayoutInflater.from(getContext()).inflate(R.layout.profile_event_row, parent, false);

        Event event = getItem(position);

        Object tag = convertView.getTag();
        ViewHolder holder;
        if (tag == null) {

            holder = new ViewHolder();

            holder.title = ((TextView) convertView.findViewById(R.id.profile_row_title));
            holder.createdBy = ((TextView) convertView.findViewById(R.id.profile_row_creator));
            holder.createdOn = ((TextView) convertView.findViewById(R.id.profile_row_created_date));
            holder.startDate = ((TextView) convertView.findViewById(R.id.profile_row_start_date));
            holder.endDate = ((TextView) convertView.findViewById(R.id.profile_row_end_date));
            holder.status = ((TextView) convertView.findViewById(R.id.profile_row_status));

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) tag;
        }

        holder.title.setText(event.getTitle());

        String createdBy = CREATED_BY + event.getCreator();
        holder.createdBy.setText(createdBy);

        String createdOn = CREATED_ON + event.getFormattedCreatedTime();
        holder.createdOn.setText(createdOn);

        String status = STATUS + event.getAttendees().get(username);
        holder.status.setText(status);

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
        TextView status;

    }

}
