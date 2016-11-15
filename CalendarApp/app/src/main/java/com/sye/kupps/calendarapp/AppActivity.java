package com.sye.kupps.calendarapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.sye.kupps.calendarapp.login.LoginActivity;

public class AppActivity extends Activity {

    public static final int CONTAINER_ID = R.id.activity_app_container;

    public static final String USER_RECOVERY_STRING = "USER_RECOVERY_STRING";

    private User user;

    ImageButton calendarButton, profileButton, newEventButton;
    public FragmentHandler fh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        fh = new FragmentHandler(AppActivity.this);

        calendarButton = (ImageButton) findViewById(R.id.calendar_image_button);
        calendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fh.replace(CONTAINER_ID, new CalendarFragment());
            }
        });

        profileButton = (ImageButton) findViewById(R.id.profile_image_button);
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fh.replace(CONTAINER_ID, new ProfileFragment());
            }
        });

        newEventButton = (ImageButton) findViewById(R.id.new_event_image_button);
        newEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fh.replace(CONTAINER_ID, new CreateEventFragment());
            }
        });
    }

}
