package com.sye.kupps.calendarapp;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A fragment class for displaying user information
 */
public class ProfileFragment extends Fragment {

    Button viewFriendsButton;
    Button viewCalendarButton;
    FragmentHandler fh;
    String username;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // TODO save username of profile as a saved instance

        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_profile, container, false);
        fh = new FragmentHandler(getActivity());

        viewCalendarButton = (Button) root.findViewById(R.id.open_calendar_from_profile);
        viewCalendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fh.replace(R.id.activity_app_container, new CalendarFragment());
            }
        });

        viewFriendsButton = (Button) root.findViewById(R.id.view_friends_button);
        viewFriendsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fh.replace(R.id.activity_app_container, new FriendListFragment());
            }
        });

        return root;
    }


}
