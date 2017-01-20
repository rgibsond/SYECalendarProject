package com.sye.kupps.calendarapp.login;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sye.kupps.calendarapp.R;
import com.sye.kupps.calendarapp.containers.User;

public class LoginFragment extends Fragment {

    // Tags
    private static final String LOG_TAG = LoginFragment.class.getName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_login, container, false);

        Button login = (Button) root.findViewById(R.id.sign_in_button);

        final EditText usernameField = (EditText) root.findViewById(R.id.username_text_field);
        final EditText passwordField = (EditText) root.findViewById(R.id.password_text_field);
        final LoginFragment thisFrag = this;
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Log.i(LOG_TAG, "Login attempt initiated");

                String username = usernameField.getText().toString();
                String password = passwordField.getText().toString();

                if (username.isEmpty() || password.isEmpty()) {

                    String message = "Both username and password must be nonempty";
                    Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();

                    Log.i(LOG_TAG, "Username or password field is empty");

                } else {

                    ((LoginActivity) getActivity()).onLoginAttempt();
                    new LoginTask(thisFrag).execute(username, password);

                }

            }
        });

        Button register = (Button) root.findViewById(R.id.sign_up_button);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(LOG_TAG, "Sent to register fragment");
                ((LoginActivity) getActivity()).goToRegister(true);
            }
        });

        Button forgotPassword = (Button) root.findViewById(R.id.forgot_password_button);
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO
                Toast.makeText(getContext(), "Sucks to suck fuckboi", Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }

    /**
     * Task used to login a user.
     * Currently mocked until more of the app is functioning
     *
     * TODO Make it work
     */
    private static class LoginTask extends AsyncTask<String, Void, User> {

        private static final String LOG_TAG = LoginTask.class.getName();

        LoginFragment loginFragment;

        LoginTask(LoginFragment fragment) {
            this.loginFragment = fragment;
        }

        @Override
        protected User doInBackground(String... params) {
            Log.i(LOG_TAG, "LoginTask initiated");

            // Simulate delayed results
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                Log.i(LOG_TAG, "Task was interrupted");
            }

            //return User.createMockUser();
            return null;
        }

        @Override
        protected void onPostExecute(User user) {
            ((LoginActivity) loginFragment.getActivity()).onLoginAttemptCompleted(user);
        }

    }

}
