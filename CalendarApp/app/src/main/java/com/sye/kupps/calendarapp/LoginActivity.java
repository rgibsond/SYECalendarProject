package com.sye.kupps.calendarapp;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class LoginActivity extends Activity {

    private LoginFragment loginFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginFragment = new LoginFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.login_activity_container, loginFragment);
        transaction.addToBackStack(null);
        transaction.commit();
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
