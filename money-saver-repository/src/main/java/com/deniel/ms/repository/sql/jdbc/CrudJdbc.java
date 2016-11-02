package com.deniel.ms.repository.sql.jdbc;

import com.deniel.ms.domain.Identifiable;
import com.deniel.ms.repository.Crud;
import com.deniel.ms.repository.sql.jdbc.util.PropertyValuesGetter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by DenielNote on 01.11.2016.
 */
public abstract class CrudJdbc<E extends Identifiable<String>> implements Crud<String, E> {
    private String URL = null;
    private String USER = null;
    private String PASSWORD = null;
    private Connection connection = null;

    public CrudJdbc(){
        PropertyValuesGetter getPropertyValues = new PropertyValuesGetter();
        URL = getPropertyValues.getDbURL() + getPropertyValues.getDbName();
        USER = getPropertyValues.getDbUserName();
        PASSWORD = getPropertyValues.getDbPass();
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(E entity) {
        try {
            PreparedStatement preparedStatement = getCreatePreparedStatement(entity) ;
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public abstract PreparedStatement getCreatePreparedStatement(E entity) throws SQLException;

    protected Connection getConnection(){
        return connection;
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
