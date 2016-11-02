package com.sye.kupps.calendarapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class PlaceholderActivity extends Activity {

    ImageButton calendarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placeholder);

        calendarButton = (ImageButton) findViewById(R.id.calendar_image_button);
        calendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO test this nonsense
                FragmentHandler fh = new FragmentHandler(PlaceholderActivity.this);
                fh.replace(R.id.activity_placeholder_container, new CalendarFragment());
            }
        });
    }

}
