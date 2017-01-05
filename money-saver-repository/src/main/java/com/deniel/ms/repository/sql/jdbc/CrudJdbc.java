package com.deniel.ms.repository.sql.jdbc;

import com.deniel.ms.domain.Identifiable;
import com.deniel.ms.exception.RepositoryException;
import com.deniel.ms.repository.Crud;

import java.sql.*;

/**
 * Created by DenielNote on 01.11.2016.
 */
public abstract class CrudJdbc<E extends Identifiable<String>> implements Crud<String, E> {
    private ConnectionManager connectionManager;
    private static final String SQL_READ_QUERY = "SELECT * FROM %s where (%s = ?)";
    private static final String SQL_DELETE_QUERY = "DELETE FROM %s where (%s = ?)";

    public CrudJdbc(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public void create(E entity) {
        try {
            PreparedStatement preparedStatement = getCreateStatement(entity);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RepositoryException("Create RepositoryException");
        }
    }

    @Override
    public E read(String id) {
        E entity = null;
        try {
            PreparedStatement preparedStatement = getParamIdStatement(id, String.format(SQL_READ_QUERY, getTableName(),
                    getTableFieldId()));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                entity = getEntity(resultSet);
            }
        } catch (SQLException e) {
            throw new RepositoryException("Read RepositoryException");
        }
        return entity;
    }

    @Override
    public void update(E entity) {
        try {
            PreparedStatement preparedStatement = getUpdateStatement(entity);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RepositoryException("Update RepositoryException", e);
        }
    }

    @Override
    public void delete(String id) {
        if (read(id) != null) {
            try {
                PreparedStatement preparedStatement = getParamIdStatement(id, String.format(SQL_DELETE_QUERY,
                        getTableName(), getTableFieldId()));
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RepositoryException("Delete RepositoryException", e);
            }
        }
    }

    protected abstract PreparedStatement getCreateStatement(E entity);

    protected abstract PreparedStatement getUpdateStatement(E entity);

    protected PreparedStatement getParamIdStatement(String id, String query) {
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, id);
            return preparedStatement;
        } catch (SQLException e) {
            throw new RepositoryException("Repository error:", e);
        }
    }

    protected abstract String getTableName();

    protected abstract String getTableFieldId();

    protected abstract E getEntity(ResultSet resultSet) throws SQLException;

    protected Connection getConnection() {
        return connectionManager.getConnection();
    }
}
