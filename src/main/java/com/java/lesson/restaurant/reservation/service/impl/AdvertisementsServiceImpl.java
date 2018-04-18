package com.java.lesson.restaurant.reservation.service.impl;

import com.java.lesson.restaurant.reservation.dao.AdvertisementsDao;
import com.java.lesson.restaurant.reservation.dao.exception.DaoException;
import com.java.lesson.restaurant.reservation.dto.Advertisement;
import com.java.lesson.restaurant.reservation.service.AdvertisementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by User on 18.04.2018.
 *
 */
@Service
public class AdvertisementsServiceImpl implements AdvertisementsService {

    @Autowired
    private AdvertisementsDao advertisementsDao;

    @Transactional
    @Override
    public List<Advertisement> getAll() throws DaoException {
        return advertisementsDao.getAll();
    }

    @Transactional
    @Override
    public Advertisement getById(int id) throws DaoException {
        return advertisementsDao.getById(id);
    }

    @Transactional
    @Override
    public void insert(Advertisement advertisement) throws DaoException {
        advertisementsDao.insert(advertisement);
    }

    @Transactional
    @Override
    public void update(Advertisement advertisement) throws DaoException {
        advertisementsDao.update(advertisement);
    }

    @Transactional
    @Override
    public void delete(int id) throws DaoException {
        advertisementsDao.delete(id);
    }
}
