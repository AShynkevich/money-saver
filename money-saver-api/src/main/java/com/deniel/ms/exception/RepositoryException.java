package com.deniel.ms.exception;

/**
 * Created by DenielNote on 04.11.2016.
 */
public class RepositoryException extends Exception {

    public RepositoryException(String message) {
        super(message);
    }

    public RepositoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
