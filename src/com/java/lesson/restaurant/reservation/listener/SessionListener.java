package com.java.lesson.restaurant.reservation.listener;

import com.java.lesson.restaurant.reservation.dao.exception.DaoException;
import com.java.lesson.restaurant.reservation.dao.impl.AdvertisementsDaoImpl;
import com.java.lesson.restaurant.reservation.dao.impl.RestaurantsDaoImpl;
import com.java.lesson.restaurant.reservation.dao.impl.UsersDaoImpl;
import com.java.lesson.restaurant.reservation.dto.AdvertisementDto;
import com.java.lesson.restaurant.reservation.dto.RestaurantDto;
import com.java.lesson.restaurant.reservation.dto.UserDto;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import static com.java.lesson.restaurant.reservation.attributes.RestaurantReservationAttributes.*;

/**
 * Created by UserDto on 09.03.2018.
 * @author Igor Iv
 */
public class SessionListener implements HttpSessionListener {

    private HttpSession session;

    private UsersDaoImpl usersDao;
    private UserDto user;

    private RestaurantsDaoImpl restaurantsDao;
    private RestaurantDto restaurant;

    private AdvertisementsDaoImpl advertisementsDao;
    private AdvertisementDto advertisement;

    public SessionListener() {
        System.out.println(">> SessionListener - NEW");
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println(">> Session - created");

//положить в сессию дао
        try {
            session = httpSessionEvent.getSession();

            usersDao = new UsersDaoImpl();
            user = new UserDto();

            restaurantsDao = new RestaurantsDaoImpl();
            restaurant = new RestaurantDto();

            advertisementsDao = new AdvertisementsDaoImpl();
            advertisement = new AdvertisementDto();

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
        user = (UserDto) session.getAttribute(USER_DTO);

        restaurantsDao = (RestaurantsDaoImpl) session.getAttribute(RESTAURANTS_DAO);
        restaurant = (RestaurantDto) session.getAttribute(RESTAURANT_DTO);

        advertisementsDao = (AdvertisementsDaoImpl) session.getAttribute(ADVERTISEMENTS_DAO);
        advertisement = (AdvertisementDto) session.getAttribute(ADVERTISEMENT_DTO);

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
