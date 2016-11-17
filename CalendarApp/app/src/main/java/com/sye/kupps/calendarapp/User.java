package com.sye.kupps.calendarapp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
     */
    public User(String user) {
        String[] userdata = user.split("\n");

        this.username = userdata[0];

        this.friends = new HashSet<>();
        if (userdata.length > 0) {
            String[] friendString = userdata[1].split(", ");
            Collections.addAll(this.friends, friendString);
        }

        this.events = new ArrayList<>();
        if (userdata.length > 1) {
            // TODO Parse event data
        }
    }

    /**
     * Returns a string for the purpose of storing and recovering user information.
     *
     * @return The recovery string
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(username);
        s.append("\n");

        String friendString = this.friends.toString();
        friendString = friendString.substring(1, friendString.length() - 1);

        s.append(friendString);
        return s.toString();
    }

}
