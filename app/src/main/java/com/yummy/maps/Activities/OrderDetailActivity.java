package com.yummy.maps.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.yummy.maps.Entities.Order;
import com.yummy.maps.R;

public class OrderDetailActivity extends AppCompatActivity {

    Order order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        Intent intent = getIntent();
        this.order = (Order) intent.getSerializableExtra("Order");
        TextView deliverItem = findViewById(R.id.deliverItem);
        TextView addressFrom = findViewById(R.id.addressFrom);
        TextView addressTo = findViewById(R.id.addressTo);
        TextView telNumber1 = findViewById(R.id.telNumber1);
        TextView dateFrom = findViewById(R.id.dateFrom);
        TextView dateTo = findViewById(R.id.dateTo);
        TextView comment1 = findViewById(R.id.comment1);
        TextView comment2 = findViewById(R.id.comment2);
        TextView costDetail = findViewById(R.id.costDetail);

        deliverItem.setText(order.getDeliverItem());
        addressFrom.setText("Адрес отправки: " + order.getAddressFrom());
        addressTo.setText("Адрес доставки: " + order.getAddressTo());
        telNumber1.setText("Номер заказчика: " + order.getTelNumber1());
        dateFrom.setText("Дата отправки: " + order.getDateFrom());
        dateTo.setText("Дата окончания: " + order.getDateTo());
        comment1.setText("Комментарий от закзачика: \n" + order.getComment1());
        comment2.setText("Комментарий от получателя: \n" + order.getComment2());
        costDetail.setText("Вознаграждение: " + order.getCostOrder() + " RUB");
    }

    public void onClickOpenMap(View view) {
        Intent intent = new Intent(OrderDetailActivity.this, MainActivity.class);
        intent.putExtra("origin", this.order.getAddressFrom());
        intent.putExtra("destination", this.order.getAddressTo());
        startActivity(intent);
    }
}
