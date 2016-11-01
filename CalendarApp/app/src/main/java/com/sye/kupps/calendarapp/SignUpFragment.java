package com.sye.kupps.calendarapp;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment {

    public static final String LOG_TAG = SignUpFragment.class.getName();

    Button registerButton;
    EditText usernameInput, passwordInput, passwordRepeat;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_sign_up, container, false);

        registerButton = (Button) root.findViewById(R.id.register_button);
        usernameInput = (EditText) root.findViewById(R.id.register_username_text_field);
        passwordInput = (EditText) root.findViewById(R.id.register_password_text_field);
        passwordRepeat = (EditText) root.findViewById(R.id.register_repeat_password_text_field);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO make this button do stuff
                // check username is unique
                // send information to database
                String username = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();
                String repeat = passwordRepeat.getText().toString();

                if (password.equals(repeat)){
                    Log.i(LOG_TAG, username + ", " + password);
                } else {
                    Log.e(LOG_TAG, "PASSWORDS DO NOT MATCH");
                }
            }
        });

        // Inflate the layout for this fragment
        return root;
    }

}
