package com.deniel.ms.exeption;

/**
 * Created by DenielNote on 04.11.2016.
 */
public class RepositoryExeption extends Exception {

    public RepositoryExeption (String message) {
        super(message);
    }

    public RepositoryExeption (String message, Throwable cause) {
        super(message, cause);
    }
}
