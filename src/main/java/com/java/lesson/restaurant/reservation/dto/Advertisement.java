package com.java.lesson.restaurant.reservation.dto;

import javax.persistence.*;

/**
 * Created by UserDto on 02.03.2018.
 *
 * @author Igor Iv.
 */
@Entity
@Table(name = "advertisements")
public class Advertisement {

    @Id
    @Column(name = "advertisement_id", nullable = false, insertable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "adv_text", nullable = false, insertable = true, updatable = true)
    String offerText;

    @Column(name = "restaurant_id", nullable = false, insertable = true, updatable = true)
    int restaurantId;

    public Advertisement() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOfferText() {
        return offerText;
    }

    public void setOfferText(String offer_text) {
        this.offerText = offer_text;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurant) {
        this.restaurantId = restaurant;
    }

    @Override
    public String toString() {
        return "\n" +
                "offer_text='" + offerText + '\'' +
                ", restaurant=" + restaurantId;
    }
}
