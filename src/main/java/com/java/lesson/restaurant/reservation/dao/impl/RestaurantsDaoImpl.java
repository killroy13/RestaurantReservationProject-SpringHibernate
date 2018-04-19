package com.java.lesson.restaurant.reservation.dao.impl;

import com.java.lesson.restaurant.reservation.dao.RestaurantsDao;
import com.java.lesson.restaurant.reservation.dao.exception.DaoException;
import com.java.lesson.restaurant.reservation.dao.exception.NoSuchEntityException;
import com.java.lesson.restaurant.reservation.dto.Restaurant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by UserDto on 20.03.2018.
 *
 */

@Repository("restaurantsDaoImpl")
public class RestaurantsDaoImpl implements RestaurantsDao {

    @Autowired
    private SessionFactory sessionFactory;

    public RestaurantsDaoImpl() throws DaoException {
    }

    @Override
    public List<Restaurant> getAll() throws DaoException {
        List<Restaurant> result;
        Session session = sessionFactory.getCurrentSession();
        try {
            result = session.createQuery("from Restaurant order by id").list();
        } catch (Exception e) {
            throw new DaoException("Error in getAll method", e);
        }
        return result;
    }

    @Override
    public Restaurant getById(int id) throws DaoException {
        Session session = sessionFactory.getCurrentSession();
        Restaurant restaurant;
        try {
            restaurant = session.get(Restaurant.class, id);
        } catch (Exception e) {
            throw new DaoException("Error in getById method", e);
        }
        if (restaurant == null) {
            throw new NoSuchEntityException("No RestaurantDto for id = '" + id + "' ");
        } else {
            return restaurant;
        }
    }

    @Override
    public void insert(Restaurant restaurant) throws DaoException {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.save(restaurant);
        } catch (Exception e) {
            throw new DaoException("Error in insert method", e);
        }
    }

    @Override
    public void update(Restaurant restaurant) throws DaoException {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.saveOrUpdate(restaurant);
        } catch (Exception e) {
            throw new DaoException("Error in update method", e);
        }
    }

    //TODO
    @Override
    public void delete(int id) throws DaoException {
        Session session = sessionFactory.getCurrentSession();
        try {
            Restaurant restaurant = session.get(Restaurant.class, id);
            session.delete(restaurant);
        } catch (Exception e) {
            throw new DaoException("Error in delete method", e);
        }
    }
}
