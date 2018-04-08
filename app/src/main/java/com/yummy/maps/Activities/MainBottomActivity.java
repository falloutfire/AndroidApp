package com.yummy.maps.Activities;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.yummy.maps.Activities.Fragments.NotificationFragment;
import com.yummy.maps.Activities.Fragments.OrderFragment;
import com.yummy.maps.Activities.Fragments.ProfileFragment;
import com.yummy.maps.Adapters.NotificationAdapter;
import com.yummy.maps.Adapters.OrdersAdapter;
import com.yummy.maps.Entities.Notification;
import com.yummy.maps.Entities.Order;
import com.yummy.maps.PointFinder;
import com.yummy.maps.R;

import java.util.ArrayList;
import java.util.Random;

public class MainBottomActivity extends Activity {


    final String LOG_TAG = "myLogs";
    ArrayList<Order> orders = new ArrayList<Order>();
    OrdersAdapter ordersAdapter;
    ArrayList<Notification> notifications = new ArrayList<Notification>();
    NotificationAdapter notificationAdapter;
    FragmentTransaction transaction;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_order:
                    //getList();
                    setFragment(new OrderFragment());
                    transaction.addToBackStack(null);
                    return true;
                case R.id.navigation_profile:
                    getList();
                    setFragment(new ProfileFragment());
                    transaction.addToBackStack(null);
                    //mTextMessage.setText(R.string.title_profile);
                    return true;
                case R.id.navigation_notifications:
                    getList();
                    //mTextMessage.setText(R.string.title_notifications);
                    setFragment(new NotificationFragment());
                    transaction.addToBackStack(null);
                    Random random = new Random();
                    return true;
            }
            return false;
        }
    };

    private void setFragment(Fragment fragment){
        transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frag_orders, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bottom);
        getList();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    void fillData(){
        orders.clear();

        PointFinder pf = new PointFinder();
        pf.execute();
        orders = pf.getOrders();
    }

    private void getList(){
        fillData();
        ordersAdapter = new OrdersAdapter(this, orders);

        ListView lvOrders = (ListView) findViewById(R.id.list_Orders);
        lvOrders.setAdapter(ordersAdapter);
        lvOrders.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(LOG_TAG, "itemClick: position = " + position + ", id = "
                        + id);
                Order order = (Order) parent.getItemAtPosition(position);
                Log.d("test_Order", order.getDeliverItem());
                Intent intent = new Intent(MainBottomActivity.this, OrderDetailActivity.class);
                intent.putExtra("Order", order);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        moveTaskToBack(true);
        finish();
        System.exit(0);
    }

    /*void fillDataNotif(){
        notifications.clear();

        notifications.clear();
        notifications.add(new Notification(1, "Доствака завершена", "Оплата вашего заказа будет совершена в течение 2 дней", "25 марта 2017"));
        notifications.add(new Notification(2, "Вы достигли 5 уровня", "Поздравляем", "23 марта 2017"));
    }

    private void getListNotif(){
        fillData();
        notificationAdapter = new NotificationAdapter(this, notifications);

        ListView lvOrders = (ListView) findViewById(R.id.list_Orders);
        lvOrders.setAdapter(notificationAdapter);
        lvOrders.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(LOG_TAG, "itemClick: position = " + position + ", id = "
                        + id);
                *//*Order order = (Order) parent.getItemAtPosition(position);
                Log.d("test_Order", order.getDeliverItem());
                Intent intent = new Intent(MainBottomActivity.this, OrderDetailActivity.class);
                intent.putExtra("Order", order);
                startActivity(intent);*//*
            }
        });
    }*/
}
