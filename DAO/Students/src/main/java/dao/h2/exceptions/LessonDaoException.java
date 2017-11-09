package dao.h2.exceptions;

import exceptions.DaoException;

public class LessonDaoException extends DaoException {
    public LessonDaoException(String message) {
        super(message);
    }

    public LessonDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
