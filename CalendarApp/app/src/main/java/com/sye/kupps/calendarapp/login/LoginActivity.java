package com.sye.kupps.calendarapp.login;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.sye.kupps.calendarapp.AppActivity;
import com.sye.kupps.calendarapp.R;

public class LoginActivity extends Activity {

    /** Reference to the fragment manager. */
    private FragmentManager fragmentManager;

    /** Login fragment */
    private LoginFragment loginFragment;

    /** Register fragment */
    private RegisterFragment registerFragment;

    /** A reference to the tag of the most recently displayed fragment. */
    private String lastFragment;

    /** Tags */
    private static final String LOGIN_FRAGMENT_TAG = "LOGIN_FRAGMENT_KEY";
    private static final String REGISTER_FRAGMENT_TAG = "REGISTER_FRAGMENT_KEY";
    private static final String LAST_FRAGMENT_TAG = "LAST_FRAGMENT_TAG";
    private static final String LOG_TAG = LoginActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        fragmentManager = getFragmentManager();

        if (savedInstanceState != null) {

            recoverFragments(savedInstanceState);

            lastFragment = savedInstanceState.getString(LAST_FRAGMENT_TAG);
            if (lastFragment == null)
                lastFragment = LOGIN_FRAGMENT_TAG;

            switch (lastFragment) {
                case LOGIN_FRAGMENT_TAG:
                    goToLogin();
                    break;
                case REGISTER_FRAGMENT_TAG:
                    goToRegister();
                    break;
                default:
                    goToLogin();
                    break;
            }

        } else {
            goToLogin();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putString(LAST_FRAGMENT_TAG, lastFragment);

        if (loginFragment != null)
            fragmentManager.putFragment(savedInstanceState, LOGIN_FRAGMENT_TAG, loginFragment);

        if (registerFragment != null)
            fragmentManager.putFragment(savedInstanceState, REGISTER_FRAGMENT_TAG, registerFragment);

    }

    private void recoverFragments(Bundle state) {
        loginFragment =
                (LoginFragment) fragmentManager.getFragment(state, LOGIN_FRAGMENT_TAG);
        registerFragment =
                (RegisterFragment) fragmentManager.getFragment(state, REGISTER_FRAGMENT_TAG);
    }

    protected void goToLogin() {

        lastFragment = LOGIN_FRAGMENT_TAG;

        if (loginFragment == null) {
            loginFragment = new LoginFragment();
            Log.i(LOG_TAG, "Created new LoginFragment");
        }

        if (registerFragment != null && registerFragment.isAdded()) {
            FragmentTransaction hide = fragmentManager.beginTransaction();
            hide.hide(registerFragment);
            hide.commit();
        }

        if (!loginFragment.isAdded()) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(R.id.login_activity_container, loginFragment, LOGIN_FRAGMENT_TAG);
            transaction.commit();
        }

        if (loginFragment.isHidden()) {
            FragmentTransaction show = fragmentManager.beginTransaction();
            show.show(loginFragment);
            show.commit();
        }

    }

    protected void goToRegister() {

        lastFragment = REGISTER_FRAGMENT_TAG;

        if (registerFragment == null) {
            registerFragment = new RegisterFragment();
            Log.i(LOG_TAG, "Created new RegisterFragment");
        }

        if (loginFragment != null && loginFragment.isAdded()) {
            FragmentTransaction hide = fragmentManager.beginTransaction();
            hide.hide(loginFragment);
            hide.commit();
        }

        if (!registerFragment.isAdded()) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(R.id.login_activity_container, registerFragment, REGISTER_FRAGMENT_TAG);
            transaction.commit();
        }

        if (registerFragment.isHidden()) {
            FragmentTransaction show = fragmentManager.beginTransaction();
            show.show(registerFragment);
            show.commit();
        }

    }

    protected void bypass() {
        Intent intent = new Intent(this, AppActivity.class);
        startActivity(intent);
        finish();
    }

}
