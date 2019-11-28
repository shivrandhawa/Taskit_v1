package com.example.taskit_v1;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class TaskFragment extends Fragment {


    public TaskFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup Container,
                             Bundle savedInstanceState) {
        super.onCreate( savedInstanceState);
//        setContentView(R.layout.activity_main);
        // Inflate the layout for this fragment
//        View v = inflater.inflate(R.layout.fragment_task, container, false);
        return inflater.inflate(R.layout.fragment_task,Container, false);
    }

}
