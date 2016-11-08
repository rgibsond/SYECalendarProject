package com.sye.kupps.calendarapp;

import java.util.ArrayList;

/**
 * Created by rgdrys13 on 11/8/2016.
 */

public class Event {

    private int id;
    long startDateTime, endDateTime;
    String title, description, creatorUsername;
    ArrayList<String> attendees, comments;
    // TODO comments class to keep track of who/when

    // constructor for creating a new event from database event string
    public Event(String rawEventData){

        // TODO parse raw data string into pieces
    }

}
