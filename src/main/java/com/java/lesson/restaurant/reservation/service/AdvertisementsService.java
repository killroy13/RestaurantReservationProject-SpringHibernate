package com.java.lesson.restaurant.reservation.service;

import com.java.lesson.restaurant.reservation.dao.GenericDao;
import com.java.lesson.restaurant.reservation.dao.exception.DaoException;
import com.java.lesson.restaurant.reservation.dto.Advertisement;

import java.util.List;

/**
 * Created by User on 18.04.2018.
 */
public interface AdvertisementsService extends GenericDao<Advertisement> {

    List<Advertisement> getAll() throws DaoException;

    Advertisement getById(int id) throws DaoException;
}
