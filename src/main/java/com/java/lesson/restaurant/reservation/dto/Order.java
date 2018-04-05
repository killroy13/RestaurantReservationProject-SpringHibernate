package com.java.lesson.restaurant.reservation.dto;

import org.springframework.stereotype.Repository;

/**
 * Created by UserDto on 02.03.2018.
 * @author Igor Iv.
 */
@Repository
public class Order extends Model {
    int user;
    int restaurant;
    String date;

    public Order(){}

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(int restaurant) {
        this.restaurant = restaurant;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "\n" +
                "user=" + user +
                ", restaurant=" + restaurant +
                ", date=" + date;
    }
}
