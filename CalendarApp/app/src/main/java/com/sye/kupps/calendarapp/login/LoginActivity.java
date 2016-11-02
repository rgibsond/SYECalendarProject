package com.sye.kupps.calendarapp.login;

import android.app.Activity;
import android.os.Bundle;

import com.sye.kupps.calendarapp.FragmentHandler;
import com.sye.kupps.calendarapp.R;

public class LoginActivity extends Activity {

    private LoginFragment loginFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // TODO fix bug where rotation closes sign up and opens log in
        FragmentHandler fh = new FragmentHandler(this);
        loginFragment = new LoginFragment();
        fh.replace(R.id.login_activity_container, loginFragment);
    }

    @Override
    protected void onPause() {
        super.onPause();
        loginFragment.retainInfo();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loginFragment.setInfo();
    }

}
