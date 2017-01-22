package com.sye.kupps.calendarapp.containers;

import java.io.Serializable;
import java.util.HashSet;

/**
 * Represents a user of the app and all of their necessary information for the app to function.
 * the toString() method of any user can be used to generate a unique user and store that user's
 * information without having to necessarily contact the database again.
 */
public class User implements Serializable {

    // Lone User instance
    private static User instance;

    private String username;

    private HashSet<Event> events;

    private HashSet<Friend> friends;

    public static User login(String user) {
        if (instance != null)
            throw new IllegalStateException("There is already a user logged in");
        instance = new User(user);
        return instance;
    }

    public static User getInstance() {
        if (instance == null)
            throw new IllegalStateException("No user is logged in");
        return instance;
    }

    public static void logout() {
        instance = null;
    }

    private User(String user) {
//        String[] userdata = user.split("\n");
//
//        this.username = userdata[0];
//
//        this.friends = new HashSet<>();
//        if (userdata.length > 0) {
//            String[] friendString = userdata[1].split(", ");
//            for (String s : friendString) {
//                // TODO
//            }
//        }
//
//        this.events = new HashSet<>();
//        if (userdata.length > 1) {
//            // TODO Parse event data
//        }
    }

    public String getUsername() {
        return this.username;
    }

    public void addEvent(Event e) {
        this.events.add(e);
    }

    public void addFriend(Friend f) {
        this.friends.add(f);
    }

    public HashSet<Friend> getFriends() {
        return this.friends;
    }

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

    // ---------------------------------------------------------------------
    // Mock methods

    private User() {
        this.username = "SwagBoi";
        this.events = new HashSet<>();
        this.friends = new HashSet<>();
    }

    public static User createMockUser() {
        return new User();
    }

}
