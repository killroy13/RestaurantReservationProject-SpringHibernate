package com.java.lesson.restaurant.reservation.dao;

import com.java.lesson.restaurant.reservation.dao.exception.NoSuchEntityException;
import com.java.lesson.restaurant.reservation.dao.exception.DaoException;
import com.java.lesson.restaurant.reservation.dto.UserDto;

import java.util.List;

/**
 * Created by UserDto on 02.03.2018.
 */
public interface UsersDao extends GenericDao<UserDto> {
    List<UserDto> getAll(/*PrintWriter printWriter*/) throws DaoException;


    //TODO NoSuchEntity
    /**
     * Never return null!
     *
     */

    UserDto getById(int id) throws DaoException, NoSuchEntityException;

    UserDto getByLoginAndPassword(String login, String password) throws DaoException, NoSuchEntityException;
}


