package com.java.lesson.restaurant.reservation.dao;

import com.java.lesson.restaurant.reservation.dao.exception.DaoException;

/**
 * Created by User on 02.03.2018.
 */
public interface GenericDao<T> {

    void insert(T t) throws DaoException;

    void update(T t) throws DaoException;

    void delete(int id) throws DaoException;

}
