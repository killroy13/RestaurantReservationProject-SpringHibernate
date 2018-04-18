package com.java.lesson.restaurant.reservation.service;

import com.java.lesson.restaurant.reservation.dao.GenericDao;
import com.java.lesson.restaurant.reservation.dao.exception.DaoException;
import com.java.lesson.restaurant.reservation.dao.exception.NoSuchEntityException;
import com.java.lesson.restaurant.reservation.dto.User;

import java.util.List;

/**
 * Created by User on 17.04.2018.
 */
public interface UsersService extends GenericDao<User> {

    List<User> getAll() throws DaoException;

    User getById(int id) throws DaoException, NoSuchEntityException;

    User getByLoginAndPassword(String login, String password) throws DaoException, NoSuchEntityException;

}
