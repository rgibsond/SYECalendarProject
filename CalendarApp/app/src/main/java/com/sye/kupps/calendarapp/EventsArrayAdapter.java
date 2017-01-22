package com.sye.kupps.calendarapp;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.sye.kupps.calendarapp.containers.Event;

/**
 * Created by rgdrys13 on 11/29/2016.
 */

public class EventsArrayAdapter extends ArrayAdapter<Event> {

    protected Event[] events;

    public EventsArrayAdapter(Context context, int resource, Event[] events) {
        super(context, resource, events);

        this.events = events;
    }


}
