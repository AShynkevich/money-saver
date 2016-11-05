package com.deniel.ms.repository.sql.jdbc.user;

import com.deniel.ms.domain.user.IUser;
import com.deniel.ms.domain.user.User;
import com.deniel.ms.exeption.RepositoryExeption;
import com.deniel.ms.repository.sql.jdbc.CrudJdbc;
import com.deniel.ms.user.IUserRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by DenielNote on 01.11.2016.
 */
public class UserRepository extends CrudJdbc<IUser> implements IUserRepository {
    private static final String TABLE_NAME = "users";
    private static final String TABLE_FIELD_ID = "user_id";
    private static final String CREATE_SQL = "INSERT INTO users values(?, ?, ?, ?, now(), now(), ?)";
    private static final String UPDATE_SQL = "UPDATE users SET user_name = ?, login = ?, pass = ?, active_flag = ?, " +
            "where user_id = ?";

    public UserRepository() throws RepositoryExeption {
    }

    @Override
    protected PreparedStatement getCreateStatement(IUser user) throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement(CREATE_SQL);
        preparedStatement.setString(1, user.getId());
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3, user.getLogin());
        preparedStatement.setString(4, user.getPass());
        preparedStatement.setBoolean(5, user.isActiveFlag());
        return preparedStatement;
    }

    @Override
    protected PreparedStatement getUpdateStatement(IUser user) throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement(UPDATE_SQL);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getLogin());
        preparedStatement.setString(3, user.getPass());
        preparedStatement.setBoolean(4, user.isActiveFlag());
        preparedStatement.setString(5, user.getId());
        return preparedStatement;
    }

    @Override
    protected IUser getEntity(ResultSet resultSet) throws SQLException {
        IUser entity = new User();
        entity.setId(resultSet.getString("user_id"));
        entity.setName(resultSet.getString("user_name"));
        entity.setLogin(resultSet.getString("login"));
        entity.setPass(resultSet.getString("pass"));
        entity.setActiveFlag(resultSet.getBoolean("active_flag"));
        return entity;
    }

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    protected String getTableFieldId() {
        return TABLE_FIELD_ID;
    }
}
