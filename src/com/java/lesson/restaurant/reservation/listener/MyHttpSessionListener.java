package com.java.lesson.restaurant.reservation.listener;

import com.java.lesson.restaurant.reservation.dao.exception.DaoException;
import com.java.lesson.restaurant.reservation.dao.impl.AdvertisementsDaoImpl;
import com.java.lesson.restaurant.reservation.dao.impl.RestaurantsDaoImpl;
import com.java.lesson.restaurant.reservation.dao.impl.UsersDaoImpl;
import com.java.lesson.restaurant.reservation.dto.Advertisement;
import com.java.lesson.restaurant.reservation.dto.Restaurant;
import com.java.lesson.restaurant.reservation.dto.User;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import static com.java.lesson.restaurant.reservation.attributes.Attributes.*;

/**
 * Created by User on 09.03.2018.
 */
public class MyHttpSessionListener implements HttpSessionListener {

    private HttpSession session;

    private UsersDaoImpl usersDao;
    private User user;

    private RestaurantsDaoImpl restaurantsDao;
    private Restaurant restaurant;

    private AdvertisementsDaoImpl advertisementsDao;
    private Advertisement advertisement;

    public MyHttpSessionListener() {
        System.out.println(">> MyHttpSessionListener - NEW");
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println(">> Session - created");

//положить в сессию дао
        try {
            session = httpSessionEvent.getSession();

            usersDao = new UsersDaoImpl();
            user = new User();

            restaurantsDao = new RestaurantsDaoImpl();
            restaurant = new Restaurant();

            advertisementsDao = new AdvertisementsDaoImpl();
            advertisement = new Advertisement();

            session.setAttribute(USERS_DAO, usersDao);
            session.setAttribute(USER_DTO, user);

            session.setAttribute(RESTAURANTS_DAO, restaurantsDao);
            session.setAttribute(RESTAURANT_DTO, restaurant);

            session.setAttribute(ADVERTISEMENTS_DAO, advertisementsDao);
            session.setAttribute(ADVERTISEMENT_DTO, advertisement);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println(">> Session - destroyed");

        usersDao = (UsersDaoImpl) session.getAttribute(USERS_DAO);
        user = (User) session.getAttribute(USER_DTO);

        restaurantsDao = (RestaurantsDaoImpl) session.getAttribute(RESTAURANTS_DAO);
        restaurant = (Restaurant) session.getAttribute(RESTAURANT_DTO);

        advertisementsDao = (AdvertisementsDaoImpl) session.getAttribute(ADVERTISEMENTS_DAO);
        advertisement = (Advertisement) session.getAttribute(ADVERTISEMENT_DTO);

        try {
            if (usersDao != null) {
                usersDao.close();
            }
            if (restaurantsDao != null){
                restaurantsDao.close();
            }
            if(advertisementsDao != null){
                advertisementsDao.close();
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
