package com.sye.kupps.calendarapp.placeholders;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ImageButton;

import com.sye.kupps.calendarapp.CalendarFragment;
import com.sye.kupps.calendarapp.FragmentHandler;
import com.sye.kupps.calendarapp.ProfileFragment;
import com.sye.kupps.calendarapp.R;

public class PlaceholderActivity extends Activity {

    public static final int CONTAINER_ID = R.id.activity_placeholder_container;

    ImageButton calendarButton, profileButton;
    FragmentHandler fh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placeholder);

        fh = new FragmentHandler(PlaceholderActivity.this);

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
