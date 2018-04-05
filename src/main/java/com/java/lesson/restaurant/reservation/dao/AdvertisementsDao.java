package com.java.lesson.restaurant.reservation.dao;

import com.java.lesson.restaurant.reservation.dao.exception.DaoException;
import com.java.lesson.restaurant.reservation.dto.Advertisement;

import java.util.List;

/**
 * Created by UserDto on 02.03.2018.
 * @author Igor Iv.
 */
public interface AdvertisementsDao extends GenericDao<Advertisement>{
    List<Advertisement> getAll() throws DaoException;

    Advertisement getById(int id) throws DaoException;
}
