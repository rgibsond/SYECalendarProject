package com.sye.kupps.calendarapp;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

/**
 * Created by rgdrys13 on 11/1/2016.
 */

//TODO update this as tasks are added to class
/** deals with such tasks as:
 * -- switching fragments within an activity
 * --
 */
public class FragmentHandler {

    Activity activity;

    public FragmentHandler(Activity activity){
        this.activity = activity;
    }

    // handles replacing a fragment with a new one
    public void replace(int containerTag, Fragment newFragment){
        FragmentManager fm = activity.getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(containerTag, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
