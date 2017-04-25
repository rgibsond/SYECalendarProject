package com.sye.kupps.calendarapp.containers;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

/**
 * Container for events
 */
public class Event implements Comparable, Serializable {

    // In millis
    long startDateTime;
    long endDateTime;
    long createdTime;

    // Other necessary info
    String title;
    String description;
    String creatorUsername;
    HashMap<String, ATTENDANCE> attendees;

    Event() {}

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public String getCreator() {
        return this.creatorUsername;
    }

    public long getStartTime() {
        return this.startDateTime;
    }

    public String getFormattedStartTime() {
        return formatTime(this.startDateTime);
    }

    public String getFormattedEndTime() {
        return formatTime(this.endDateTime);
    }

    public String getFormattedCreatedTime() {
        return formatTime(this.createdTime);
    }

    private static String formatTime(long millis) {
        Date date = new Date(millis);
        SimpleDateFormat formatter = new SimpleDateFormat("LLLL d, yyyy - h:mm a", Locale.US);
        return formatter.format(date);
    }

    public long getEndTime() {
        return this.endDateTime;
    }

    public long getCreatedTime() {
        return this.createdTime;
    }

    public HashMap<String, ATTENDANCE> getAttendees() {
        return this.attendees;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(creatorUsername);
        builder.append("\n");
        builder.append(getFormattedStartTime());
        builder.append("\n");
        builder.append(getFormattedEndTime());
        builder.append("\n");
        for (String key : attendees.keySet()) {
            builder.append(key);
            builder.append(" ---> ");
            builder.append(attendees.get(key));
        }

        return builder.toString();
    }

    @Override
    public int compareTo(Object o) {
        Event other = (Event) o;
        long diff = other.createdTime - this.createdTime;
        if (diff > 0)
            return 1;
        else if (diff < 0)
            return -1;
        else
            return 0;
    }

    enum ATTENDANCE {
        Going,
        NotGoing,
        Invited,
        Maybe
    }

}
