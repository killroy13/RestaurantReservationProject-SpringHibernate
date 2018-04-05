package com.java.lesson.restaurant.reservation.dao;

import com.java.lesson.restaurant.reservation.dao.exception.DaoException;
import com.java.lesson.restaurant.reservation.dao.exception.NoSuchEntityException;
import com.java.lesson.restaurant.reservation.dto.User;

import java.util.List;

/**
 * Created by UserDto on 02.03.2018.
 */

//@Repository
public interface UsersDao extends GenericDao<User> {
    List<User> getAll() throws DaoException;


    //TODO NoSuchEntity
    /**
     * Never return null!
     *
     */

    User getById(int id) throws DaoException, NoSuchEntityException;

    User getByLoginAndPassword(String login, String password) throws DaoException, NoSuchEntityException;
}


