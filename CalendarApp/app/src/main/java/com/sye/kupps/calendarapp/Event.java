package com.sye.kupps.calendarapp;

import java.util.ArrayList;

public class Event {

    private int id;
    private long startDateTime;
    private long endDateTime;
    private String title;
    private String description;
    private String creatorUsername;
    private ArrayList<String> attendees;
    private ArrayList<String> comments;

    // constructor for creating a new event from database event string
    public Event(String rawEventData){

    }

}
