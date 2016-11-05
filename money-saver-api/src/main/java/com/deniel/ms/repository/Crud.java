package com.deniel.ms.repository;

import com.deniel.ms.domain.Identifiable;
import com.deniel.ms.exeption.RepositoryExeption;

/**
 * Created by DenielNote on 01.11.2016.
 */
public interface Crud<K, E extends Identifiable<K>> {

    void create(E entity) throws RepositoryExeption;

    E read(K id) throws RepositoryExeption;

    void update(E entity) throws RepositoryExeption;

    void delete(K id) throws RepositoryExeption;
}