package com.java.lesson.restaurant.reservation.dao.impl;

import com.java.lesson.restaurant.reservation.dao.UsersDao;
import com.java.lesson.restaurant.reservation.dao.exception.DaoException;
import com.java.lesson.restaurant.reservation.dao.exception.NoSuchEntityException;
import com.java.lesson.restaurant.reservation.dto.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by UserDto on 03.03.2018.
 */

@Repository("usersDaoImpl")
public class UsersDaoImpl /*extends AbstractMySQLDao<User> */implements UsersDao {

    @Autowired
    private SessionFactory sessionFactory;

    public UsersDaoImpl() throws DaoException {
    }

    @Override
    public List<User> getAll() throws DaoException {
        List<User> result;
        Session session = sessionFactory.getCurrentSession();
        try {
            result = session.createQuery("from User order by id").list();
        } catch (Exception e) {
            throw new DaoException("Error in getAll method", e);
        }
        return result;
    }

    @Override
    public User getById(int id) throws DaoException {
        Session session = sessionFactory.getCurrentSession();
        User user;
        try {
            user = session.get(User.class, id);
        } catch (Exception e) {
            throw new DaoException("Error in getById method", e);
        }
        if (user == null) {
            throw new NoSuchEntityException("No Users for id = '" + id + "' ");
        } else {
            return user;
        }
    }

    //TODO логином может выступать email
    @Override
    public User getByLoginAndPassword(String login, String password) throws DaoException, NoSuchEntityException {
        Session session = sessionFactory.getCurrentSession();
        User user;
        try {
            Query query = session.createQuery("from User where login=:log and password=:pas");
            query.setParameter("log", login);
            query.setParameter("pas", password);
            user = (User) query.uniqueResult();
        } catch (Exception e) {
            throw new DaoException("Error in getByLoginAndPassword method", e);
        }
        if (user == null) {
            throw new NoSuchEntityException("No Users for login = '" + login + "' ");
        } else {
            return user;
        }
    }

    @Override
    public void insert(User user) throws DaoException {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.save(user);
        } catch (Exception e) {
            throw new DaoException("Error in insert method", e);
        }
    }

    @Override
    public void update(User user) throws DaoException {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.saveOrUpdate(user);
        } catch (Exception e) {
            throw new DaoException("Error in update method", e);
        }
    }

    @Override
    public void delete(int id) throws DaoException {
        Session session = sessionFactory.getCurrentSession();
        try {
            User user = session.get(User.class, id);
            session.delete(user);
        } catch (Exception e) {
            throw new DaoException("Error in delete method", e);
        }
    }
}
