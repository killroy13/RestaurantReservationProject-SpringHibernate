package com.java.lesson.restaurant.reservation.service.impl;

import com.java.lesson.restaurant.reservation.dao.RestaurantsDao;
import com.java.lesson.restaurant.reservation.dao.exception.DaoException;
import com.java.lesson.restaurant.reservation.dto.Restaurant;
import com.java.lesson.restaurant.reservation.service.RestaurantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by User on 18.04.2018.
 *
 */
@Service
public class RestaurantsServiceImpl implements RestaurantsService {

    @Autowired
    private RestaurantsDao restaurantsDao;

    @Transactional
    @Override
    public List<Restaurant> getAll() throws DaoException {
        return restaurantsDao.getAll();
    }

    @Transactional
    @Override
    public Restaurant getById(int id) throws DaoException {
        return restaurantsDao.getById(id);
    }

    @Transactional
    @Override
    public void insert(Restaurant restaurant) throws DaoException {
        restaurantsDao.insert(restaurant);
    }

    @Transactional
    @Override
    public void update(Restaurant restaurant) throws DaoException {
        restaurantsDao.update(restaurant);
    }

    @Transactional
    @Override
    public void delete(int id) throws DaoException {
        restaurantsDao.delete(id);
    }
}
