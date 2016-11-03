package com.deniel.ms.repository.sql.jdbc;

import com.deniel.ms.domain.Identifiable;
import com.deniel.ms.repository.Crud;
import com.deniel.ms.repository.sql.jdbc.util.PropertyValuesGetter;

import java.sql.*;

/**
 * Created by DenielNote on 01.11.2016.
 */
public abstract class CrudJdbc<E extends Identifiable<String>> implements Crud<String, E> {
    private Connection connection = null;
    private static final String SQL_READ_QUERY = "SELECT * FROM %s where (%s = ?)";
    private static final String SQL_DELETE_QUERY = "DELETE FROM %s where (%s = ?)";

    public CrudJdbc() {
        PropertyValuesGetter getPropertyValues = new PropertyValuesGetter();
        String url = getPropertyValues.getDbURL() + getPropertyValues.getDbName();
        String user = getPropertyValues.getDbUserName();
        String pass = getPropertyValues.getDbPass();
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(E entity) {
        try {
            PreparedStatement preparedStatement = getCreateStatement(entity);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public E read(String id) {
        E entity = null;
        try {
            PreparedStatement preparedStatement = getParamIdStatement(id, String.format(SQL_READ_QUERY, getTableName(), getTableFieldId()));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                entity = getEntity(resultSet);
            }
        } catch (SQLException e) {
            System.out.println("SQL exception");
        }
        return entity;
    }

    @Override
    public void update(E entity) {
        try {
            PreparedStatement preparedStatement = getUpdateStatement(entity);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        if (read(id) != null) {
            try {
                PreparedStatement preparedStatement = getParamIdStatement(id, String.format(SQL_DELETE_QUERY, getTableName(), getTableFieldId()));
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                System.out.println("SQL exception");
            }
        }
    }

    protected abstract PreparedStatement getCreateStatement(E entity) throws SQLException;

    protected abstract PreparedStatement getUpdateStatement(E entity) throws SQLException;

    protected PreparedStatement getParamIdStatement(String id, String query) throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement(query);
        preparedStatement.setString(1, id);
        return preparedStatement;
    }

    protected abstract String getTableName();

    protected abstract String getTableFieldId();

    protected abstract E getEntity(ResultSet resultSet) throws SQLException;

    protected Connection getConnection() {
        return connection;
    }
}
