package com.java.lesson.restaurant.reservation.dto;

/**
 * Created by User on 02.03.2018.
 */
public class Model {
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "\n" + "id=" + id;
    }
}
