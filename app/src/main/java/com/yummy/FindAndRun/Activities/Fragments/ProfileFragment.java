package com.yummy.FindAndRun.Activities.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yummy.FindAndRun.Entities.Rating;
import com.yummy.FindAndRun.Entities.User;
import com.yummy.FindAndRun.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        TextView av_rateView = null;
        if (view != null) {
            av_rateView = view.findViewById(R.id.av_rate);
            TextView levelView = view.findViewById(R.id.level);
            TextView userNameView = view.findViewById(R.id.UserName);
            ArrayList<Rating> ratings = new ArrayList<>();
            //Log.d("my_log", "TEST");
            //Говнокод!
            for (int i = 0; i < 3; i++) {
                ratings.add(new Rating());
                ratings.get(i).setRateOrder(i + 1);
            }

            double av_rating = 0;
            for (int i = 0; i < ratings.size(); i++) {
                av_rating += ratings.get(i).getRateOrder();
            }
            av_rating /= ratings.size();

            int level = 0;

            User user = new User("Shenok77", ratings, 5, 5);

            av_rateView.setText(String.valueOf(user.getAv_rating()));
            //вот здесь крашиться приложение
            //levelView.setText(user.getLevel());
            userNameView.setText(user.getUsername());
        }
    }
}
