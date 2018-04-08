package com.yummy.FindAndRun.Activities.Fragments;


import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.yummy.FindAndRun.Adapters.OrdersAdapter;
import com.yummy.FindAndRun.Entities.Order;
import com.yummy.FindAndRun.PointFinder;
import com.yummy.FindAndRun.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFragment extends Fragment{

    ArrayList<Order> orders = new ArrayList<Order>();
    OrdersAdapter ordersAdapter;
    View view;

    HttpURLConnection urlConnection = null;
    BufferedReader reader = null;
    String resultJson = "";
    String LOG_TAG = "my_log";

    public OrderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        /*View view = getActivity().findViewById(R.id.fragment);
        if(view != null){
            orders.clear();
            *//*PointFinder pf = new PointFinder();
            pf.execute();
            orders = pf.getOrders();*//*
            ordersAdapter = new OrdersAdapter(getActivity(), orders);
            ListView lvOrders = (ListView) view.findViewById(R.id.list_Orders);
            lvOrders.setAdapter(ordersAdapter);
        }*/
    }
}
