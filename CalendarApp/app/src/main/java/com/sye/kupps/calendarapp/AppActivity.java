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

    @Override
    public void onResume() {
        super.onResume();

        // Recreate user from preferences
        String userString = getPreferences(MODE_PRIVATE).getString(USER_RECOVERY_STRING, null);

        if (userString == null)  { // Redirect to login if no one is logged in
            Intent login = new Intent(this, LoginActivity.class);
            startActivity(login);
        }

        user = new User(userString, false);
    }

    @Override
    public void onPause() {
        super.onPause();

        // Write user data to preferences for recovery
        String userString = user.toString();
        getPreferences(MODE_PRIVATE).edit().putString(USER_RECOVERY_STRING, userString).apply();
    }
}
