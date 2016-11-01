package com.deniel.ms.repository;

import com.deniel.ms.domain.Identifiable;

/**
 * Created by DenielNote on 01.11.2016.
 */
public interface Crud<K, E extends Identifiable<K>> {

    void create(E entity);

    E read(K id);

    void update(E entity);

    boolean delete(K id);
}