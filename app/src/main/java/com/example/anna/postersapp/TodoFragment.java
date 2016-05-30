package com.example.anna.postersapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anna.postersapp.api.User;

/**
 * Created by anna on 5/23/16.
 */
public class TodoFragment extends Fragment {

    public static TodoFragment newInstance(User user){
        TodoFragment fragment = new TodoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.todos_fragment, container, false);
        return rootView;
    }

}
