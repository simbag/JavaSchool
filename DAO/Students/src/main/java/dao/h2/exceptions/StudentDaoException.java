package dao.h2.exceptions;

import exceptions.DaoException;

public class StudentDaoException extends DaoException {
    public StudentDaoException(String message) {
        super(message);
    }

    public StudentDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
