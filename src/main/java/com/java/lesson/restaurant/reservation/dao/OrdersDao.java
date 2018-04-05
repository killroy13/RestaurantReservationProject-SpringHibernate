package com.java.lesson.restaurant.reservation.dao;

import com.java.lesson.restaurant.reservation.dao.exception.DaoException;
import com.java.lesson.restaurant.reservation.dto.Order;

import java.util.List;

/**
 * Created by UserDto on 02.03.2018.
 * @author Igor Iv.
 */
public interface OrdersDao extends GenericDao<Order> {
    List<Order> getAll() throws DaoException;

    Order getById(int id) throws DaoException;
}
