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

    String bio;

    LinkedList<Event> events;

    ArrayList<String> friends;

    User() {}

    public String getUsername() {
        return this.username;
    }

    public LinkedList<Event> getEvents() {
        return this.events;
    }

    public ArrayList<Event> getAssociatedEvents() {
        ArrayList<Event> myEvents = new ArrayList<>();
        for (Event e : events) {
            if (e.getAttendees().get(username) != null)
                myEvents.add(e);
        }
        Collections.sort(myEvents);
        return myEvents;
    }

    public void addEvent(Event event) {
        events.addFirst(event);
    }

    public String getBio() {
        return this.bio;
    }

    public ArrayList<String> getFriends() {
        Collections.sort(friends);
        return this.friends;
    }

}
