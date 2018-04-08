package com.yummy.FindAndRun.Activities.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.yummy.FindAndRun.Adapters.NotificationAdapter;
import com.yummy.FindAndRun.Adapters.OrdersAdapter;
import com.yummy.FindAndRun.Entities.Notification;
import com.yummy.FindAndRun.PointFinder;
import com.yummy.FindAndRun.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFragment extends Fragment {

    ArrayList<Notification> notifications = new ArrayList<Notification>();
    NotificationAdapter notificationAdapter;

    public NotificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        
        return inflater.inflate(R.layout.fragment_notification, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View view = getActivity().findViewById(R.id.frag_orders);
        if(view != null){
            notifications.clear();
            notifications.add(new Notification(1, "Доставка завершена", "Оплата вашего заказа будет совершена в течение 2 дней", "25 марта 2017"));
            notifications.add(new Notification(2, "Вы достигли 5 уровня", "Поздравляем", "23 марта 2017"));

            notificationAdapter = new NotificationAdapter(getActivity(), notifications);
            ListView lvOrders = (ListView) view.findViewById(R.id.list_notif);
            lvOrders.setAdapter(notificationAdapter);
        }
    }

}
