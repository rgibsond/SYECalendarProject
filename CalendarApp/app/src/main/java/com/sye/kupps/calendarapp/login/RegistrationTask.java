package com.sye.kupps.calendarapp.login;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.sye.kupps.calendarapp.DatabaseManager;


public class RegistrationTask extends AsyncTask<String[], Void, Boolean> {

    private static final String LOG_TAG = RegistrationTask.class.getName();

    private String username;

    private String password;

    public RegistrationTask(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    protected Boolean doInBackground(String[]... params) {
        DatabaseManager databaseManager = new DatabaseManager();
        return databaseManager.register(username, password);
    }

    @Override
    protected void onPostExecute(Boolean result) {
        String log = result ? "Successful registration" : "Failed Registration";
        Log.i(LOG_TAG, log);
    }

}
