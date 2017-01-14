package com.sye.kupps.calendarapp.login;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sye.kupps.calendarapp.R;
import com.sye.kupps.calendarapp.User;

public class LoginFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_login, container, false);

        Button register = (Button) root.findViewById(R.id.sign_up_button);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((LoginActivity) getActivity()).goToRegister();
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

        @Override
        protected User doInBackground(String... params) {
            return null;
        }

        @Override
        protected void onPostExecute(User user) {

        }

    }

}
