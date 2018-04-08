package com.yummy.maps.Entities;

import java.util.ArrayList;

/**
 * Created by yablo on 24.03.2018.
 */

public class User {
    private String username;
    private ArrayList<Rating> ratings = new ArrayList<>();
    private double av_rating;
    private int level;

    public User(String username, ArrayList<Rating> ratings, double av_rating, int level) {
        this.username = username;
        this.ratings = ratings;
        this.av_rating = av_rating;
        this.level = level;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Rating> ratings) {
        this.ratings = ratings;
    }

    public double getAv_rating() {
        return av_rating;
    }

    public void setAv_rating(double av_rating) {
        this.av_rating = av_rating;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
