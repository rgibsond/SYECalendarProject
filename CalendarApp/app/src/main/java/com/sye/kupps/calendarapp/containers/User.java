package com.sye.kupps.calendarapp.containers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;


/**
 * User container
 */
public class User implements Serializable {

    String username;

    LinkedList<Event> events;

    ArrayList<String> friends;

    User() {}

    public String getUsername() {
        return this.username;
    }

    public LinkedList<Event> getEvents() {
        return this.events;
    }

    public ArrayList<Event> getUserCreatedEvents() {
        ArrayList<Event> myEvents = new ArrayList<>();
        for (Event e : events) {
            if (e.getCreator().equals(username))
                myEvents.add(e);
        }
        return myEvents;
    }

    public void addEvent(Event e) {
        this.events.addFirst(e);
    }

    public void addFriend(String f) {
        this.friends.add(f);
    }

    public ArrayList<String> getFriends() {
        Collections.sort(friends);
        return this.friends;
    }

}
