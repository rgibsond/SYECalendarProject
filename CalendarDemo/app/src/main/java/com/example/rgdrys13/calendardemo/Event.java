package com.example.rgdrys13.calendardemo;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by rgdrys13 on 10/20/2016.
 */

public class Event {

    // instance data


    private long start, end;
    String description;
    // a list of the participants by their user IDs
    ArrayList<Integer> participants;

    // start and end time given as ints in seconds from beginning of the day
    public Event(int month, int day, int year, int startTime, int endTime){

    }

    private long convertToLong(Date date, int time){

        return 0;
    }

}
