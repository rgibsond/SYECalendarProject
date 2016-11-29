package com.sye.kupps.calendarapp.login;

import android.os.AsyncTask;
import android.util.Log;
import com.sye.kupps.calendarapp.DatabaseManager;
import com.sye.kupps.calendarapp.User;


class LoginTask extends AsyncTask<String, Void, User> {

    private static final String LOG_TAG = LoginTask.class.getName();

    private LoginFragment loginFragment;

    LoginTask(LoginFragment loginFragment) {
        this.loginFragment = loginFragment;
    }

    @Override
    protected User doInBackground(String... params) {

        DatabaseManager databaseManager = new DatabaseManager();
        String loginInfo = databaseManager.login(params[0], params[1]);

        boolean loginSuccessful = loginInfo != null;
        Log.i(LOG_TAG, "Login successful: " + loginSuccessful);

        User loggedInUser = null;
        if (loginSuccessful)
            loggedInUser = new User(loginInfo);

        return loggedInUser;
    }

    @Override
    protected void onPostExecute(User result) {
        this.loginFragment.onLoginAttemptCompleted(result);
    }

}
