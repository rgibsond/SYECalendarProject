package com.sye.kupps.calendarapp;

import android.os.AsyncTask;

/**
 * Created by rgdrys13 on 12/6/2016.
 */

public class EventRetrieverTask extends AsyncTask<String, Void, Event[]> {

    public static final String LOG_TAG = EventRetrieverTask.class.getName();

    @Override
    protected Event[] doInBackground(String... strings) {
        return new Event[0];
    }

    @Override
    protected void onPostExecute(Event[] events) {
        super.onPostExecute(events);
    }
}
