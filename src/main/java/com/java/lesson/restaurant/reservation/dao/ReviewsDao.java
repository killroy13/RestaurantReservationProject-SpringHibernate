package com.java.lesson.restaurant.reservation.dao;

import com.java.lesson.restaurant.reservation.dao.exception.DaoException;
import com.java.lesson.restaurant.reservation.dto.Review;

import java.util.List;

/**
 * Created by UserDto on 02.03.2018.
 * @author Igor Iv.
 */
public interface ReviewsDao extends GenericDao<Review>{
    List<Review> getAll() throws DaoException;

    Review getById(int id) throws DaoException;
}
