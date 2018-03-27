package com.java.lesson.restaurant.reservation.dao.exception;

/**
 * Created by UserDto on 02.03.2018.
 * @author Igor Iv.
 */
public class DaoException extends Exception {
    public DaoException() {
    }

    public DaoException(String message) {
        super(message);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
