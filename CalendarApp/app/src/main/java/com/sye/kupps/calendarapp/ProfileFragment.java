package com.sye.kupps.calendarapp;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.sye.kupps.calendarapp.containers.User;

/**
 * A fragment class for displaying user information
 */
public class ProfileFragment extends Fragment {

    private static final String LOG_TAG = ProfileFragment.class.getName();

    private ListView events;
    private static final String EVENT_POSITION = "EVENT_POSITION";
    private static final String EVENT_OFFSET = "EVENT_OFFSET";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        User user = ((AppActivity) getActivity()).getUser();

        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_profile, container, false);

        ((TextView) root.findViewById(R.id.profile_name)).setText(user.getUsername());
        ((TextView) root.findViewById(R.id.profile_bio)).setText(user.getBio());

        events = (ListView) root.findViewById(R.id.profile_list_view);
        events.setAdapter(new ProfileEventAdapter(getContext(), R.layout.profile_event_row, user.getAssociatedEvents()));

        if (savedInstanceState != null) {
            int position = savedInstanceState.getInt(EVENT_POSITION);
            int offset = savedInstanceState.getInt(EVENT_OFFSET);
            events.setSelectionFromTop(position, offset);
        }

        // TODO make buttons do stuff
        Button goToFriends = (Button) root.findViewById(R.id.view_friends_button);
        goToFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((AppActivity) getActivity()).fh.replace(AppActivity.CONTAINER_ID, new FriendListFragment(), true);
            }
        });

        Button goToCalendar = (Button) root.findViewById(R.id.open_calendar_from_profile);
        goToCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((AppActivity) getActivity()).fh.replace(AppActivity.CONTAINER_ID, new CalendarFragment(), true);
            }
        });

        return root;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(EVENT_POSITION, events.getFirstVisiblePosition());

        View v = events.getChildAt(0);
        int offset = (v == null) ? 0 : (v.getTop() - events.getPaddingTop());
        savedInstanceState.putInt(EVENT_OFFSET, offset);
    }

}
