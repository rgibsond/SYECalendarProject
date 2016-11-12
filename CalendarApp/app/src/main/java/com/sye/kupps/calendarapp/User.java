package com.sye.kupps.calendarapp;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Represents a user of the app and all of their necessary information for the app to function.
 * the toString() method of any user can be used to generate a unique user and store that user's
 * information without having to necessarily contact the database again.
 */
public class User {

    /** The username of this user. */
    private String username;

    /** A list of the events this user is attending/hosting. */
    private ArrayList<Event> events;

    /** The set of the user's friends. */
    private HashSet<String> friends;

    /**
     * Used to build a User from a string unique to a specific user.
     *
     * @param user The string to build the user from.
     * @param newUser Determines whether or not to treat user as a username or user recovery string
     */
    public User(String user, boolean newUser) {
        if (newUser)
            generateNewUser(user);
        else
            restoreUser(user);
    }

    /**
     * Instantiates fields from the database information
     *
     * @param username The username from which to pull data
     */
    private void generateNewUser(String username) {
        // TODO
    }

    /**
     * Instantiates fields from parsing the userString
     *
     * @param userString The userString to parse
     */
    private void restoreUser(String userString) {
        // TODO
    }

    /**
     * Returns a string for the purpose of storing and recovering user information.
     *
     * @return The recovery string
     */
    @Override
    public String toString() {
        // TODO
        return null;
    }

}
