package com.sye.kupps.calendarapp.containers;

import java.util.HashSet;

/**
 * Container for events
 */
public class Event {

    // Unique id num
    private int id;

    // In millis
    private long startDateTime;
    private long endDateTime;

    // Other necessary info
    private String title;
    private String description;
    private String creatorUsername;
    private HashSet<Friend> attendees;
    private HashSet<Comment> comments;

    // Constructor for creating a new event from database event string
    public Event(String rawEventData){

    }

}
