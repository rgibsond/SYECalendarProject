package com.sye.kupps.calendarapp;


import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class FriendListFragment extends ListFragment {

    @Override
    public void onCreate(Bundle inState) {
        super.onCreate(inState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle inState) {
        super.onActivityCreated(inState);
        AppActivity app = (AppActivity) getActivity();
        setListAdapter(new ArrayAdapter<>(getContext(),
                android.R.layout.simple_list_item_1,
                app.getUser().getFriends()));
    }

}
