package com.sye.kupps.calendarapp.login;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.sye.kupps.calendarapp.DatabaseManager;
import com.sye.kupps.calendarapp.FragmentHandler;
import com.sye.kupps.calendarapp.PlaceholderActivity;
import com.sye.kupps.calendarapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment {

    public static final String LOG_TAG = SignUpFragment.class.getName();

    Button registerButton, backToSignInButton, bypass;
    EditText usernameInput, passwordInput, passwordRepeat;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_sign_up, container, false);

        registerButton = (Button) root.findViewById(R.id.register_button);
        backToSignInButton = (Button) root.findViewById(R.id.back_to_sign_in_button);
        usernameInput = (EditText) root.findViewById(R.id.register_username_text_field);
        passwordInput = (EditText) root.findViewById(R.id.register_password_text_field);
        passwordRepeat = (EditText) root.findViewById(R.id.register_repeat_password_text_field);
        bypass = (Button) root.findViewById(R.id.bypass);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();
                String repeat = passwordRepeat.getText().toString();

                if (password.equals(repeat)){
                    Log.i(LOG_TAG, username + ", " + password);
                } else {
                    Log.e(LOG_TAG, "PASSWORDS DO NOT MATCH");
                }

                new RegistrationTask(username, password).execute();
            }
        });

        backToSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // re-replace this fragment with a new Login Fragment
                FragmentHandler fh = new FragmentHandler(getActivity());
                fh.replace(R.id.login_activity_container, new LoginFragment());
            }
        });

        bypass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PlaceholderActivity.class);
                startActivity(intent);
            }
        });

        // Inflate the layout for this fragment
        return root;
    }

    //TODO retain and set info as in LoginFragment.java

}
