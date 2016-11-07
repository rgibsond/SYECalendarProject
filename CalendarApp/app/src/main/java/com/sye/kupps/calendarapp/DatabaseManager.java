package com.sye.kupps.calendarapp;

import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
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

    /**
     * This is the IP Address of my MAMP server. As long as the testing device is on SLU wifi
     * this connection should work provided my laptop is on and the server is running.
     */
    private static final String DATABASE_LINK = "http://10.70.0.95/index.php";

    /** String returned from the server when there is a failure to connect to the database. */
    private static final String FAILED_CONNECTION = "Failed Connection";

    /** Post data identifiers */
    private static final String REGISTER = "SIGN_UP";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    private static final String LOG_TAG = DatabaseManager.class.getName();

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

        StringBuilder postParams = new StringBuilder();
        try {
            postParams.append(REGISTER);
            postParams.append("=");
            postParams.append(URLEncoder.encode(REGISTER, "UTF-8"));
            postParams.append("&");
            postParams.append(USERNAME);
            postParams.append("=");
            postParams.append(URLEncoder.encode(username, "UTF-8"));
            postParams.append("&");
            postParams.append(PASSWORD);
            postParams.append("=");
            postParams.append(URLEncoder.encode(password, "UTF-8"));
        } catch (IOException e) {
            Log.e(LOG_TAG, e.toString());
        }

        String serverResponse = sendPostData(postParams.toString());
        Log.i(LOG_TAG, "Server response: " + serverResponse);
        if (serverResponse == null || serverResponse.equals(failedResponse))
            return false;

        return serverResponse.equals(successResponse);
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
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(response));
            String result = reader.readLine();
            reader.close();
            return result;

        } catch (IOException e) {
            Log.i(LOG_TAG, e.toString());
            return null;
        }
    }

}
