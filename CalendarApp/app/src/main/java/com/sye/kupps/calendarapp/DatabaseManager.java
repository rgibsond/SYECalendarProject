package com.sye.kupps.calendarapp;

import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Handles all interactions to the database.
 *
 * Whenever using this class, everything should be called in an
 * AsyncTask to avoid holding up the UI thread.
 *
 * From the AsyncTask that calls the DatabaseManager a API object
 * should be returned to the rest of the app (i.e. a User object,
 * a Timeline object, an Event object, etc.)
 */
public class DatabaseManager {

    // TODO NEED TO FIGURE OUT PASSWORD HASHING

    /**
     * This is the IP Address of my MAMP server. As long as the testing device is on SLU wifi
     * this connection should work provided my laptop is on and the server is running.
     */
    private static final String DATABASE_LINK = "http://10.70.0.95/index.php";

    /** String returned from the server when there is a failure to connect to the database. */
    private static final String FAILED_CONNECTION = "Failed Connection";

    /** Post data identifiers */
    private static final String REGISTER = "SIGN_UP";
    private static final String LOGIN = "SIGN_IN";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    private static final String LOG_TAG = DatabaseManager.class.getName();

    /**
     * Sends a request to the database for verification of a username and password combo.
     *
     * @param username The username of the attempted login
     * @param password The password of the attempted login
     *
     * @return True if the login was successful and false otherwise.
     */
    public boolean login(String username, String password) {
        String successResponse = "0";
        String failedResponse = "-1";

        String[][] params = {
                {LOGIN, LOGIN},
                {USERNAME, username},
                {PASSWORD, password}
        };

        String postData = buildPostParams(params);
        String serverResponse = sendPostData(postData);

        Log.i(LOG_TAG, "Server response: " + serverResponse);

        return !(serverResponse == null || serverResponse.equals(failedResponse))
                && serverResponse.equals(successResponse);
    }

    /**
     * Sends a request to the database to register a new user with the passed username
     *
     * @param username The username to be registered
     * @param password The corresponding password
     *
     * @return
     *      True if the registration was successful and false if the username was already in
     *      the database.
     */
    public boolean register(String username, String password) {

        String successResponse = "0";
        String failedResponse = "-1";

        String[][] params = {
                {REGISTER, REGISTER},
                {USERNAME, username},
                {PASSWORD, password}
        };

        String postData = buildPostParams(params);
        String serverResponse = sendPostData(postData);

        Log.i(LOG_TAG, "Server response: " + serverResponse);

        return !(serverResponse == null || serverResponse.equals(failedResponse))
                && serverResponse.equals(successResponse);
    }

    /**
     * Builds a post string to be sent to the server
     *
     * @param params The mapped array of post parameters
     * @return The single post string to be sent to the server
     */
    private String buildPostParams(String[][] params) {

        StringBuilder paramString = new StringBuilder();

        try {

            for (int i = 0; i < params.length; i++) {
                paramString.append(params[i][0]);
                paramString.append("=");
                paramString.append(URLEncoder.encode(params[i][1], "UTF-8"));
                if (i != params.length - 1)
                    paramString.append("&");
            }

            return paramString.toString();

        } catch (IOException e) {
            Log.e(LOG_TAG, e.toString());
            return null;
        }
    }

    /**
     * Sends post parameters in postData in the to the server and returns the
     * output of php script from the server.
     *
     * @param postParams Post data in the form of a string
     *
     * @return The response from the server in the form of a String. CAN RETURN NULL
     */
    private String sendPostData(String postParams) {
        try {

            // Open connection to server
            URL databaseURL = new URL(DATABASE_LINK);
            HttpURLConnection conn = (HttpURLConnection) databaseURL.openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");

            // Write post data to connection
            DataOutputStream write = new DataOutputStream(conn.getOutputStream());
            write.writeBytes(postParams);
            write.flush();
            write.close();

            // Get response
            InputStream response = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(response));
            String result = reader.readLine();
            reader.close();
            return result;

        } catch (IOException e) {
            Log.i(LOG_TAG, e.toString());
            return null;
        }
    }

}
