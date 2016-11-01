package com.deniel.ms.repository.sql.jdbc;

import com.deniel.ms.domain.Identifiable;
import com.deniel.ms.repository.Crud;

/**
 * Created by DenielNote on 01.11.2016.
 */
public class CrudJdbc<E extends Identifiable<String>> implements Crud<String, E> {

    @Override
    public void create(E entity) {

    }

    @Override
    public E read(String id) {
        return null;
    }

    @Override
    public void update(E entity) {

    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
