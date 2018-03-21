package com.java.lesson.restaurant.reservation.dto;

/**
 * Created by User on 02.03.2018.
 */
public class Advertisement extends Model{
    String offerText;
    int restaurantId;

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
