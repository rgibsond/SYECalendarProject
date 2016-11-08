package com.sye.kupps.calendarapp.login;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.sye.kupps.calendarapp.DatabaseManager;

public class RegistrationTask extends AsyncTask<String, Void, Boolean> {

    private static final String LOG_TAG = RegistrationTask.class.getName();

    @Override
    protected Boolean doInBackground(String ... params) {
        if (params.length != 2)
            throw new IllegalArgumentException("Must pass two strings. username, password");
        DatabaseManager databaseManager = new DatabaseManager();
        return databaseManager.register(params[0], params[1]);
    }

    @Override
    protected void onPostExecute(Boolean result) {
        String log = result ? "Successful registration" : "Failed Registration";
        Log.i(LOG_TAG, log);

        if (result) {

        } else {

        }

    }

}
