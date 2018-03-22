package com.java.lesson.restaurant.reservation.dao;

import com.java.lesson.restaurant.reservation.dao.exception.DaoException;
import com.java.lesson.restaurant.reservation.dto.ReviewDto;

import java.util.List;

/**
 * Created by UserDto on 02.03.2018.
 * @author Igor Iv.
 */
public interface ReviewsDao extends GenericDao<ReviewDto>{
    List<ReviewDto> getAll() throws DaoException;

    ReviewDto getById(int id) throws DaoException;
}
