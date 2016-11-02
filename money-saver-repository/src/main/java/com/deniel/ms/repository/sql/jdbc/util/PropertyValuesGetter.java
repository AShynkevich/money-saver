package com.deniel.ms.repository.sql.jdbc.util;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Deniel on 25.05.2016.
 */
public class PropertyValuesGetter {
    private String dbURL = "";
    private String dbName = "";
    private String dbUserName = "";
    private String dbPass = "";
    private String DEFAULT_DBPROPERTIES_PATH = "/db.properties";

    public PropertyValuesGetter() {
        getPropertyValues();
    }

    private void getPropertyValues() {
        Properties properties = new Properties();
        InputStream inputStream;
        String categoryPath = System.getProperty("properties.path");
        try {
            if (StringUtils.isBlank(categoryPath)) {
                inputStream = getClass().getResourceAsStream(DEFAULT_DBPROPERTIES_PATH);
            } else {
                File file = new File(categoryPath + DEFAULT_DBPROPERTIES_PATH);
                inputStream = new FileInputStream(file);
            }
            properties.load(inputStream);
            dbURL = properties.getProperty("dbConnectionURL");
            dbName = properties.getProperty("dbName");
            dbUserName = properties.getProperty("dbUserName");
            dbPass = properties.getProperty("dbPass");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getDbUserName() {
        return dbUserName;
    }

    public String getDbURL() {
        return dbURL;
    }

    public String getDbName() {
        return dbName;
    }

    public String getDbPass() {
        return dbPass;
    }
}


