package com.sye.kupps.calendarapp.login;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.sye.kupps.calendarapp.AppActivity;
import com.sye.kupps.calendarapp.R;
import com.sye.kupps.calendarapp.containers.User;

public class LoginActivity extends Activity {

    private FragmentManager fragmentManager;

    private LoginFragment loginFragment;

    private RegisterFragment registerFragment;

    // Used for verifying which fragment was last showing on rotation
    private int lastFragment;

    // If true an async task is in progress and the wait screen should remain visible
    private boolean taskInProgress;

    // Tags
    private static final String LOGIN_FRAGMENT_TAG = "LOGIN_FRAGMENT_KEY";
    private static final String REGISTER_FRAGMENT_TAG = "REGISTER_FRAGMENT_KEY";
    private static final String LAST_FRAGMENT_TAG = "LAST_FRAGMENT_TAG";
    private static final String USER_STRING = "USER_STRING";
    private static final String USER_OBJECT = "USER_OBJECT";
    private static final String TASK_IN_PROGRESS_TAG = "TASK_IN_PROGRESS_TAG";
    private static final String LOG_TAG = LoginActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        String userString = getPreferences(MODE_PRIVATE).getString(USER_STRING, null);
        if (userString != null) {
            Intent app = new Intent(this, AppActivity.class);
            app.putExtra(USER_STRING, userString);
            startActivity(app);
            finish();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        fragmentManager = getFragmentManager();
        //fragmentManager.addOnBackStackChangedListener(this);

        if (savedInstanceState != null) {

            recoverFragments(savedInstanceState);

            checkForTask(savedInstanceState);

            lastFragment = savedInstanceState.getInt(LAST_FRAGMENT_TAG);
            if (!taskInProgress) {
                switch (lastFragment) {
                    case 0:
                        goToLogin(false);
                        break;
                    case 1:
                        goToRegister(false);
                        break;
                    default:
                        goToLogin(false);
                        break;
                }
            }

        } else {
            instantiateFragments();
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(LAST_FRAGMENT_TAG, lastFragment);
        savedInstanceState.putBoolean(TASK_IN_PROGRESS_TAG, taskInProgress);

        if (loginFragment != null)
            fragmentManager.putFragment(savedInstanceState, LOGIN_FRAGMENT_TAG, loginFragment);

        if (registerFragment != null)
            fragmentManager.putFragment(savedInstanceState, REGISTER_FRAGMENT_TAG, registerFragment);

        super.onSaveInstanceState(savedInstanceState);
    }

    private void recoverFragments(Bundle state) {
        loginFragment =
                (LoginFragment) fragmentManager.getFragment(state, LOGIN_FRAGMENT_TAG);
        registerFragment =
                (RegisterFragment) fragmentManager.getFragment(state, REGISTER_FRAGMENT_TAG);
    }

    private void instantiateFragments() {
        loginFragment = new LoginFragment();
        registerFragment = new RegisterFragment();

        lastFragment = 0;

        FragmentTransaction init = fragmentManager.beginTransaction();
        init.add(R.id.login_activity_container, loginFragment, LOGIN_FRAGMENT_TAG);
        init.add(R.id.login_activity_container, registerFragment, REGISTER_FRAGMENT_TAG);
        init.hide(registerFragment);
        init.commit();
    }

    protected void checkForTask(Bundle savedInstanceState) {
        taskInProgress = savedInstanceState.getBoolean(TASK_IN_PROGRESS_TAG, false);
        if (taskInProgress) {
            if (loginFragment != null && loginFragment.isAdded()) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.hide(loginFragment);
                transaction.commit();
            }

            if (registerFragment != null && registerFragment.isAdded()) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.hide(registerFragment);
                transaction.commit();
            }

            View waitView = findViewById(R.id.login_wait_screen);
            if (waitView.getVisibility() == View.GONE)
                waitView.setVisibility(View.VISIBLE);
        }
    }

    protected void goToLogin(boolean addToBackStack) {

        lastFragment = 0;

        FragmentTransaction swap = fragmentManager.beginTransaction();
        if (!registerFragment.isHidden())
            swap.hide(registerFragment);
        if (loginFragment.isHidden())
            swap.show(loginFragment);
        if (addToBackStack)
            swap.addToBackStack(LOGIN_FRAGMENT_TAG);

        swap.commit();
    }

    protected void goToRegister(boolean addToBackStack) {

        lastFragment = 1;

        FragmentTransaction swap = fragmentManager.beginTransaction();
        if (!loginFragment.isHidden())
            swap.hide(loginFragment);
        if (registerFragment.isHidden())
            swap.show(registerFragment);

        if (addToBackStack)
            swap.addToBackStack(REGISTER_FRAGMENT_TAG);

        swap.commit();
    }

    protected void onLoginAttempt() {
        taskInProgress = true;

        FragmentTransaction hide = fragmentManager.beginTransaction();
        hide.hide(loginFragment);
        hide.commit();

        View waitView = findViewById(R.id.login_wait_screen);
        waitView.setVisibility(View.VISIBLE);
    }

    protected void onLoginAttemptCompleted(User user) {
        taskInProgress = false;
        if (user == null) {

            View waitView = findViewById(R.id.login_wait_screen);
            waitView.setVisibility(View.GONE);

            goToLogin(false);

            String message = "Username or password is incorrect";
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        } else {

            Intent app = new Intent(this, AppActivity.class);
            app.putExtra(USER_OBJECT, user);
            startActivity(app);
            finish();

        }
    }

    protected void onRegistrationAttempt() {
        taskInProgress = true;

        FragmentTransaction hide = fragmentManager.beginTransaction();
        hide.hide(registerFragment);
        hide.commit();

        View waitView = findViewById(R.id.login_wait_screen);
        waitView.setVisibility(View.VISIBLE);
    }

    protected void onRegistrationAttemptCompleted(User user) {
        taskInProgress = false;
        if (user == null) {

            View waitView = findViewById(R.id.login_wait_screen);
            waitView.setVisibility(View.GONE);

            goToRegister(false);

            String message = "Username is already in use";
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        } else {

            Intent app = new Intent(this, AppActivity.class);
            app.putExtra(USER_OBJECT, user);
            startActivity(app);
            finish();
        }
    }

//    @Override
//    public void onBackStackChanged() {
//        lastFragment ^= 1;
//    }

}
