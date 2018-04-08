package com.yummy.FindAndRun.Activities.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yummy.FindAndRun.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryOrdersFragment extends Fragment {


    public HistoryOrdersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history_orders, container, false);
    }

}
