package com.java.lesson.restaurant.reservation.dao.exception;

/**
 * Created by User on 09.03.2018.
 */
public class DaoBusinessException extends DaoException {
    public DaoBusinessException(String message){
        super(message);
    }
    public DaoBusinessException(String message, Throwable cause){
        super(message, cause);
    }
}
