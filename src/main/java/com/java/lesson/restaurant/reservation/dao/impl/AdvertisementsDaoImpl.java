package com.java.lesson.restaurant.reservation.dao.impl;

import com.java.lesson.restaurant.reservation.dao.AdvertisementsDao;
import com.java.lesson.restaurant.reservation.dao.exception.DaoException;
import com.java.lesson.restaurant.reservation.dto.Advertisement;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by UserDto on 21.03.2018.
 *
 */

@Repository("advertisementsDao")
public class AdvertisementsDaoImpl implements AdvertisementsDao {

    @Autowired
    SessionFactory sessionFactory;

    public AdvertisementsDaoImpl() throws DaoException {
    }

    @Override
    public List<Advertisement> getAll() throws DaoException {
        Session session = sessionFactory.getCurrentSession();
        List<Advertisement> result;
        try {
            result = session.createQuery("from Advertisement order by id").list();
        } catch (Exception e) {
            throw new DaoException("Error in getAll method", e);
        }
        return result;
    }

    @Override
    public Advertisement getById(int id) throws DaoException {
        Session session = sessionFactory.getCurrentSession();
        Advertisement advertisement;
        try {
            advertisement = session.get(Advertisement.class, id);
        } catch (Exception e) {
            throw new DaoException("Error in getById method", e);
        }
        return advertisement;
    }

    @Override
    public void insert(Advertisement advertisement) throws DaoException {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.save(advertisement);
        } catch (Exception e) {
            throw new DaoException("Error in insert method", e);
        }
    }

    //TODO рассмотреть возможность изменения (необходима ли функция??)
    @Override
    public void update(Advertisement advertisement) throws DaoException {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.saveOrUpdate(advertisement);
        } catch (Exception e) {
            throw new DaoException("Error in update method", e);
        }
    }

    @Override
    public void delete(int id) throws DaoException {
        Session session = sessionFactory.getCurrentSession();
        try {
            Advertisement advertisement = session.get(Advertisement.class, id);
            session.delete(advertisement);
        } catch (Exception e) {
            throw new DaoException("Error in delete method", e);
        }
    }
}
