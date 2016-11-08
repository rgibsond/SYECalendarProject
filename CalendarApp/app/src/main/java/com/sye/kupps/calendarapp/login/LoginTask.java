package com.sye.kupps.calendarapp.login;

import android.os.AsyncTask;
import android.util.Log;

import com.sye.kupps.calendarapp.DatabaseManager;


public class LoginTask extends AsyncTask<String, Void, Boolean> {

    private static final String LOG_TAG = LoginTask.class.getName();

    @Override
    protected Boolean doInBackground(String... params) {
        DatabaseManager databaseManager = new DatabaseManager();
        return databaseManager.login(params[0], params[1]);
    }

    @Override
    protected void onPostExecute(Boolean result) {
        String logResult = result ? "Successful Login" : "Failed Login";
        Log.i(LOG_TAG, logResult);
    }

}
