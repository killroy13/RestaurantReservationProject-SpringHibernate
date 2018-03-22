package com.java.lesson.restaurant.reservation.dao;

import com.java.lesson.restaurant.reservation.dao.exception.DaoException;
import com.java.lesson.restaurant.reservation.dto.AdvertisementDto;

import java.util.List;

/**
 * Created by UserDto on 02.03.2018.
 * @author Igor Iv.
 */
public interface AdvertisementsDao extends GenericDao<AdvertisementDto>{
    List<AdvertisementDto> getAll() throws DaoException;

    AdvertisementDto getById(int id) throws DaoException;
}
