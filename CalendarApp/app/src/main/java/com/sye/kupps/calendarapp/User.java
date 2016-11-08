package com.sye.kupps.calendarapp;

import java.util.ArrayList;

/**
 * Represents a user of the app and all of their necessary information for the app to function.
 * the toString() method of any user can be used to generate a unique user and store that user's
 * information without having to necessarily contact the database again.
 */
public class User {

    private String username;

    private ArrayList<Integer> friends;

    public User(String userString) {

    }

    public User() {

    }

    /**
     * Returns a string for the purpose of storing and recovering user information.
     * @return The recovery string
     */
    @Override
    public String toString() {
        return null;
    }

}
