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
import android.widget.Toast;

import com.sye.kupps.calendarapp.R;
import com.sye.kupps.calendarapp.containers.User;

public class RegisterFragment extends Fragment {

    // Tags
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

        final EditText usernameInput = (EditText) root.findViewById(R.id.register_username_text_field);
        final EditText passwordInput = (EditText) root.findViewById(R.id.register_password_text_field);
        final EditText passwordRepeat = (EditText) root.findViewById(R.id.register_repeat_password_text_field);
        final RegisterFragment fragment = this;
        Button registerButton = (Button) root.findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();
                String repeat = passwordRepeat.getText().toString();

                // Displays various toasts based on failed register attempts
                String message;
                if (username.isEmpty()) {
                    message = "Must have a username";
                    Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
                } else if (password.isEmpty()) {
                    message = "Cannot have empty password";
                    Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
                } else if (!password.equals(repeat)) {
                    message = "Passwords must match";
                    Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
                } else {
                    Log.i(LOG_TAG, "RegistrationTask initialized");
                    ((LoginActivity) getActivity()).onRegistrationAttempt();
                    new RegisterTask(fragment).execute(username, password);
                }
            }
        });

        Button backToSignInButton = (Button) root.findViewById(R.id.back_to_sign_in_button);
        backToSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(LOG_TAG, "Sent to login fragment");
                ((LoginActivity) getActivity()).goToLogin(true);
            }
        });

        return root;
    }

    /**
     * Task used to register new users in the database.
     * Currently this is mocked until more of the app's functionality is available.
     *
     * TODO Actually contact the database
     */
    private static class RegisterTask extends AsyncTask<String, Void, User> {

        RegisterFragment registerFragment;

        RegisterTask(RegisterFragment fragment) {
            this.registerFragment = fragment;
        }

        @Override
        protected User doInBackground(String... params) {

            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                Log.i(LOG_TAG, "Register task interrupted");
            }

            //return User.createMockUser();
            return null;
        }

        @Override
        protected void onPostExecute(User user) {
            ((LoginActivity) registerFragment.getActivity()).onRegistrationAttemptCompleted(user);
        }

    }

}
