package com.deniel.ms.repository.sql.jdbc;

import com.deniel.ms.exception.MsSystemException;
import com.deniel.ms.repository.sql.jdbc.util.PropertyValuesGetter;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by DenielNote on 05.11.2016.
 */
public class ConnectionManager {
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static ConnectionManager instance;
    private Connection connection = null;

    public static synchronized ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance;
    }
    
    private ConnectionManager() {
        PropertyValuesGetter getPropertyValues = new PropertyValuesGetter();
        String url = getPropertyValues.getDbURL() + getPropertyValues.getDbName();
        String user = getPropertyValues.getDbUserName();
        String pass = getPropertyValues.getDbPass();
        try {
            connection = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            throw new MsSystemException("Money-saver system exception", e);
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
