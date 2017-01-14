package com.sye.kupps.calendarapp.login;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.sye.kupps.calendarapp.R;
import com.sye.kupps.calendarapp.User;

public class RegisterFragment extends Fragment {

    private Button registerButton;
    private Button backToSignInButton;
    private Button bypass;
    private EditText usernameInput;
    private EditText passwordInput;
    private EditText passwordRepeat;

    /** Tags */
    private static final String LOG_TAG = RegisterFragment.class.getName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_sign_up, container, false);

        registerButton = (Button) root.findViewById(R.id.register_button);

        backToSignInButton = (Button) root.findViewById(R.id.back_to_sign_in_button);

        bypass = (Button) root.findViewById(R.id.bypass);

        usernameInput = (EditText) root.findViewById(R.id.register_username_text_field);

        passwordInput = (EditText) root.findViewById(R.id.register_password_text_field);

        passwordRepeat = (EditText) root.findViewById(R.id.register_repeat_password_text_field);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String username = usernameInput.getText().toString();
//                String password = passwordInput.getText().toString();
//                String repeat = passwordRepeat.getText().toString();
//
//                if (password.equals(repeat)){
//                    Log.i(LOG_TAG, username + ", " + password);
//                    new RegistrationTask().execute(username, password);
//                } else {
//                    Log.e(LOG_TAG, "PASSWORDS DO NOT MATCH");
//                }

            }
        });

        backToSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((LoginActivity) getActivity()).goToLogin();
            }
        });

        bypass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((LoginActivity) getActivity()).bypass();
            }
        });

        // Inflate the layout for this fragment
        return root;
    }

    /**
     * Task used to register new users in the database.
     * Currently this is mocked until more of the app's functionality is available.
     *
     * TODO Actually contact the database
     */
    private static class RegisterTask extends AsyncTask<String, Void, User> {

        @Override
        protected User doInBackground(String... params) {
            return null;
        }

        @Override
        protected void onPostExecute(User user) {

        }

    }

}
