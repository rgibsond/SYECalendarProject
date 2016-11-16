package com.sye.kupps.calendarapp;

import java.sql.Timestamp;

/**
 * Container class to keep track of user, time, and contents of
 * comments on an event
 *
 * Created by rgdrys13 on 11/16/2016.
 */

public class Comment {

    private static final String REGEX = "#&&#";

    private String comment, usernameOfOwner;
    private Timestamp timeOfComment;

    public Comment (String rawData){
        // TODO send in comment data as "TIMESTAMP#&&#USERNAMEOFOWNER#&&#COMMENT"
        String[] data = rawData.split(REGEX);
        this.timeOfComment = Timestamp.valueOf(data[0]);
        this.usernameOfOwner = data[1];
        this.comment = data[2];
    }

    public String getComment() {
        return comment;
    }

    public String getUsernameOfOwner() {
        return usernameOfOwner;
    }

    public Timestamp getTimeOfComment() {
        return timeOfComment;
    }
}
