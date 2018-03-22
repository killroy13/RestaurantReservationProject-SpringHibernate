package com.java.lesson.restaurant.reservation.dao;

import com.java.lesson.restaurant.reservation.dao.exception.DaoException;
import com.java.lesson.restaurant.reservation.dto.OrderDto;

import java.util.List;

/**
 * Created by UserDto on 02.03.2018.
 * @author Igor Iv.
 */
public interface OrdersDao extends GenericDao<OrderDto> {
    List<OrderDto> getAll() throws DaoException;

    OrderDto getById(int id) throws DaoException;
}
