package com.java.lesson.restaurant.reservation.service.impl;

import com.java.lesson.restaurant.reservation.dao.UsersDao;
import com.java.lesson.restaurant.reservation.dao.exception.DaoException;
import com.java.lesson.restaurant.reservation.dao.exception.NoSuchEntityException;
import com.java.lesson.restaurant.reservation.dto.User;
import com.java.lesson.restaurant.reservation.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by User on 17.04.2018.
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    @Transactional
    @Override
    public List<User> getAll() throws DaoException {
        return usersDao.getAll();
    }

    @Transactional
    @Override
    public User getById(int id) throws DaoException, NoSuchEntityException {
        return usersDao.getById(id);
    }

    @Transactional
    @Override
    public User getByLoginAndPassword(String login, String password) throws DaoException, NoSuchEntityException {
        return usersDao.getByLoginAndPassword(login, password);
    }

    @Transactional
    @Override
    public void insert(User user) throws DaoException {
        usersDao.insert(user);
    }

    @Transactional
    @Override
    public void update(User user) throws DaoException {
        usersDao.update(user);
    }

    @Transactional
    @Override
    public void delete(int id) throws DaoException {
        usersDao.delete(id);
    }
}
