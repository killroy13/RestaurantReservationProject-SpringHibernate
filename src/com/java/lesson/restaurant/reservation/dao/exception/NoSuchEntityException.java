package com.java.lesson.restaurant.reservation.dao.exception;

/**
 * Created by User on 09.03.2018.
 */
public class NoSuchEntityException extends DaoBusinessException {
    public NoSuchEntityException(String message) {
        super(message);
    }

    public NoSuchEntityException(String message, Throwable cause) {
        super(message, cause);
    }
}
