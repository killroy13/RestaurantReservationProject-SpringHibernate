package com.java.lesson.restaurant.reservation.attributes;

import com.java.lesson.restaurant.reservation.dao.exception.DaoException;
import com.java.lesson.restaurant.reservation.dao.impl.AdvertisementsDaoImpl;
import com.java.lesson.restaurant.reservation.dao.impl.RestaurantsDaoImpl;
import com.java.lesson.restaurant.reservation.dao.impl.UsersDaoImpl;
import com.java.lesson.restaurant.reservation.dto.Advertisement;
import com.java.lesson.restaurant.reservation.dto.Restaurant;
import com.java.lesson.restaurant.reservation.dto.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by User on 01.04.2018.
 */
@Configuration
@ComponentScan("com.java.lesson.restaurant.reservation")
public class RestaurantReservationConfig {

    @Bean(name = "userDao")
    public UsersDaoImpl usersDao() throws DaoException {
        return new UsersDaoImpl();
    }

    @Bean
    public RestaurantsDaoImpl restaurantsDao() throws DaoException{
        return new RestaurantsDaoImpl();
    }

    @Bean
    public AdvertisementsDaoImpl advertisementsDao() throws DaoException{
        return new AdvertisementsDaoImpl();
    }



    @Bean
    public User user (){
        return new User();
    }

    @Bean
    public Restaurant restaurant() {
        return new Restaurant();
    }

    @Bean
    public Advertisement advertisement(){
        return new Advertisement();
    }




}
