package com.sye.kupps.calendarapp;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment {

    Button registerButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_sign_up, container, false);

        registerButton = (Button) root.findViewById(R.id.register_button);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO make this button do stuff
                // check username is unique
                // send information to database
            }
        });

        // Inflate the layout for this fragment
        return root;
    }

}
