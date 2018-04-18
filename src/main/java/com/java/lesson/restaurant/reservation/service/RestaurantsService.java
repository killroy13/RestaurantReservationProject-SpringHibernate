package com.java.lesson.restaurant.reservation.service;

import com.java.lesson.restaurant.reservation.dao.GenericDao;
import com.java.lesson.restaurant.reservation.dao.exception.DaoException;
import com.java.lesson.restaurant.reservation.dto.Restaurant;

import java.util.List;

/**
 * Created by User on 18.04.2018.
 */
public interface RestaurantsService extends GenericDao<Restaurant>{

    List<Restaurant> getAll() throws DaoException;

    Restaurant getById(int id) throws DaoException;
}
