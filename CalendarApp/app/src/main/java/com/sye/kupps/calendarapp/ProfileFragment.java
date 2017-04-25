package com.sye.kupps.calendarapp;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.sye.kupps.calendarapp.containers.User;
import com.sye.kupps.calendarapp.placeholders.ProfileEventAdapter;

/**
 * A fragment class for displaying user information
 */
public class ProfileFragment extends Fragment {

    private ListView events;
    private static final String EVENTS = "EVENTS";

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
        if (savedInstanceState != null)
            events.onRestoreInstanceState(savedInstanceState.getParcelable(EVENTS));
        else {
            ProfileEventAdapter eventAdapter = new ProfileEventAdapter(getContext(), R.layout.profile_event_row, user.getAssociatedEvents());
            eventAdapter.setUsername(user.getUsername());
            events.setAdapter(eventAdapter);
        }
        // TODO make buttons do stuff

        return root;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putParcelable(EVENTS, events.onSaveInstanceState());
    }

}
