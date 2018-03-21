package com.java.lesson.restaurant.reservation.dao;

import com.java.lesson.restaurant.reservation.dao.exception.DaoException;
import com.java.lesson.restaurant.reservation.dto.Restaurant;

import java.util.List;

/**
 * Created by User on 02.03.2018.
 */
public interface RestaurantsDao extends GenericDao<Restaurant> {

    List<Restaurant> getAll() throws DaoException;

    Restaurant getById(int id) throws DaoException;
}
