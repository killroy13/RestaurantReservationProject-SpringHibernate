package com.java.lesson.restaurant.reservation.dao;

import com.java.lesson.restaurant.reservation.dao.exception.DaoException;

/**
 * Created by UserDto on 02.03.2018.
 * @author Igor Iv.
 */
public interface GenericDao<T> {

    void insert(T t) throws DaoException;

    void update(T t) throws DaoException;

    void delete(int id) throws DaoException;

}
