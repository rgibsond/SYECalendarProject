package com.sye.kupps.calendarapp;

import android.os.Bundle;
import android.app.Fragment;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.sye.kupps.calendarapp.containers.Event;
import com.sye.kupps.calendarapp.containers.User;

import java.util.Calendar;

public class CreateEventFragment extends Fragment {

    // TODO make this post new event data to the database

    public static final String LOG_TAG = CreateEventFragment.class.getName();

    EditText eventNameInput, eventDescriptionInput;
    DatePicker datePicker;
    TimePicker startTimePicker, endTimePicker;
    Button submitButton, cancelButton;
    User me;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_create_event, container, false);

        eventNameInput = (EditText) root.findViewById(R.id.event_name_input);
        eventDescriptionInput = (EditText) root.findViewById(R.id.new_event_description_field);
        datePicker = (DatePicker) root.findViewById(R.id.new_event_date_input);
        startTimePicker = (TimePicker) root.findViewById(R.id.event_start_time_input);
        endTimePicker = (TimePicker) root.findViewById(R.id.event_end_time_input);
        me = ((AppActivity) getActivity()).getUser();

        submitButton = (Button) root.findViewById(R.id.submit_new_event_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int startTime = (startTimePicker.getHour() * 60) + startTimePicker.getMinute();
                int endTime = (endTimePicker.getHour()*60) + endTimePicker.getMinute();

                // make sure start time is before end time
                // if it isn't send toast to screen saying so
                if (startTime < endTime){

                    String name = eventNameInput.getText().toString();
                    String description = eventDescriptionInput.getText().toString();

                    int year = datePicker.getYear();
                    int month = datePicker.getMonth() +1;
                    int day = datePicker.getDayOfMonth();

                    long createdTime = System.currentTimeMillis();

                    // convert to milliseconds
                    // start time
                    Calendar c = Calendar.getInstance();
                    c.set(year, month, day, startTimePicker.getHour(), startTimePicker.getMinute());
                    long startTimeMill = c.getTimeInMillis();

                    // end time
                    c.set(year, month, day, endTimePicker.getHour(), endTimePicker.getMinute());
                    long endTimeMill = c.getTimeInMillis();

                    // create event
                    Event e = new Event(startTimeMill, endTimeMill, createdTime, name, description, me.getUsername());

                    me.addEvent(e);

                    Toast.makeText(getContext(), "EVENT SUCCESSFULLY CREATED", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(getContext(), "Input valid start & end times", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cancelButton = (Button) root.findViewById(R.id.cancel_new_event_button);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().popBackStack();
            }
        });

        return root;
    }

}
