package com.java.lesson.restaurant.reservation.dao;

import com.java.lesson.restaurant.reservation.dao.exception.DaoException;
import com.java.lesson.restaurant.reservation.dto.RestaurantDto;

import java.util.List;

/**
 * Created by UserDto on 02.03.2018.
 * @author Igor Iv.
 */
public interface RestaurantsDao extends GenericDao<RestaurantDto> {

    List<RestaurantDto> getAll() throws DaoException;

    RestaurantDto getById(int id) throws DaoException;
}
