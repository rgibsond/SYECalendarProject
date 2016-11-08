package com.sye.kupps.calendarapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AppActivity extends Activity {

    public static final int CONTAINER_ID = R.id.activity_app_container;

    ImageButton calendarButton, profileButton;
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
    }
}
