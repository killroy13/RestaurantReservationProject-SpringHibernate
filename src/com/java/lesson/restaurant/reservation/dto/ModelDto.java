package com.java.lesson.restaurant.reservation.dto;

/**
 * Created by UserDto on 02.03.2018.
 * @author Igor Iv.
 */
public class ModelDto {
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
