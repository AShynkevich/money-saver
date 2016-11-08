package com.deniel.ms.repository;

import com.deniel.ms.domain.Identifiable;
import com.deniel.ms.exception.RepositoryException;

/**
 * Created by DenielNote on 01.11.2016.
 */
public interface Crud<K, E extends Identifiable<K>> {

    void create(E entity) throws RepositoryException;

    E read(K id) throws RepositoryException;

    void update(E entity) throws RepositoryException;

    void delete(K id) throws RepositoryException;
}