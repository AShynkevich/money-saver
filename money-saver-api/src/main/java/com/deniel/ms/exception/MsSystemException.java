package com.deniel.ms.exception;

/**
 * Created by DenielNote on 08.11.2016.
 */
public class MsSystemException extends RuntimeException {

    public MsSystemException(String message) {
        super(message);
    }

    public MsSystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
