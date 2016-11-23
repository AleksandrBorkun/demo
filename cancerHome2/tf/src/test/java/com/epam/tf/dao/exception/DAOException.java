package com.epam.tf.dao.exception;


/**
 * Created by Hleb_Turchyk on 11/09/2016.
 */
public class DAOException extends Exception {
    public DAOException() {
        super();
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }
}
