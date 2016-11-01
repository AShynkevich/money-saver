package com.deniel.ms.domain;

/**
 * Created by DenielNote on 01.11.2016.
 */
public interface Identifiable <T> {
    public T getId();

    public void setId (T id);
}
