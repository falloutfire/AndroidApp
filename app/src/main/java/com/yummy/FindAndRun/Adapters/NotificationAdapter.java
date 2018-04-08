package com.yummy.FindAndRun.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yummy.FindAndRun.Entities.Notification;
import com.yummy.FindAndRun.R;

import java.util.ArrayList;

/**
 * Created by Man on 25.03.2018.
 */

public class NotificationAdapter extends BaseAdapter{

    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Notification> notifications;

    public NotificationAdapter(Context ctx, ArrayList<Notification> notifications) {
        this.ctx = ctx;
        lInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.notifications = notifications;
    }

    @Override
    public int getCount() {
        return notifications.size();
    }

    @Override
    public Object getItem(int position) {
        return notifications.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.list_item_notificaton, parent, false);
        }

        Notification notification = getNotification(position);

        // заполняем View в пункте списка данными из товаров: наименование, цена
        // и картинка
        ((TextView) view.findViewById(R.id.titleNotification)).setText(notification.getTitle());
        ((TextView) view.findViewById(R.id.descriptionNotification)).setText(notification.getDescription());
        ((TextView) view.findViewById(R.id.dateNotification)).setText(notification.getDate());
        ((ImageView) view.findViewById(R.id.imageOrder)).setImageResource(R.drawable.ic_dashboard_white_24dp);

        return view;
    }

    private Notification getNotification(int position) {
        return ((Notification) getItem(position));
    }
}
