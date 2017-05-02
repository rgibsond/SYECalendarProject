package com.sye.kupps.calendarapp;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.sye.kupps.calendarapp.containers.User;
import com.sye.kupps.calendarapp.login.LoginActivity;

public class AppActivity extends Activity {

    public static final int CONTAINER_ID = R.id.activity_app_container;
    public static final String USER_OBJECT = "USER_OBJECT";

    private User user;

    ImageButton calendarButton, profileButton, newEventButton, feedButton;
    public FragmentHandler fh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        // TODO GET USER OBJECT
        user = (User) getIntent().getSerializableExtra(USER_OBJECT);

        fh = new FragmentHandler(AppActivity.this);

        calendarButton = (ImageButton) findViewById(R.id.calendar_image_button);
        calendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fh.replace(CONTAINER_ID, new CalendarFragment(), true);
            }
        });

        profileButton = (ImageButton) findViewById(R.id.profile_image_button);
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fh.replace(CONTAINER_ID, new ProfileFragment(), true);
            }
        });

        newEventButton = (ImageButton) findViewById(R.id.new_event_image_button);
        newEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fh.replace(CONTAINER_ID, new CreateEventFragment(), true);
            }
        });

        feedButton = (ImageButton) findViewById(R.id.newsfeed_image_button);
        feedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fh.replace(CONTAINER_ID, new TimelineFragment(), true);
            }
        });

        fh.replace(CONTAINER_ID, new TimelineFragment(), false);
    }

    public User getUser() {
        return this.user;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

}
