package com.sye.kupps.calendarapp;

import android.app.Activity;
import android.os.Bundle;

public class LoginActivity extends Activity {

    private LoginFragment loginFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginFragment = (LoginFragment) getFragmentManager().findFragmentById(R.id.login_fragment);
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
