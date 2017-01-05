package com.deniel.ms.repository.sql.jdbc.user;

import com.deniel.ms.domain.user.*;
import com.deniel.ms.exception.RepositoryException;
import com.deniel.ms.repository.sql.jdbc.ConnectionManager;
import com.deniel.ms.repository.sql.jdbc.CrudJdbc;
import com.deniel.ms.user.IUserRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DenielNote on 01.11.2016.
 */
public class UserRepository extends CrudJdbc<IUser> implements IUserRepository {
    private static final String TABLE_NAME = "users";
    private static final String TABLE_FIELD_ID = "user_id";
    private static final String CREATE_SQL = "INSERT INTO users values(?, ?, ?, ?, now(), now(), ?)";
    private static final String UPDATE_SQL = "UPDATE users SET user_name = ?, login = ?, pass = ?, active_flag = ?, " +
            "where user_id = ?";
    private static final String USER_ROLES_SQL = "SELECT users.*, roles.role_name, roles.role_id FROM users, roles WHERE login = ?";

    public UserRepository(ConnectionManager connectionManager) {
        super(connectionManager);
    }

    @Override
    protected PreparedStatement getCreateStatement(IUser user) {
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(CREATE_SQL);
            preparedStatement.setString(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setString(4, user.getPass());
            preparedStatement.setBoolean(5, user.isActiveFlag());
            return preparedStatement;
        } catch (SQLException e) {
            throw new RepositoryException("Repository error: ", e);
        }
    }

    @Override
    protected PreparedStatement getUpdateStatement(IUser user) {
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(UPDATE_SQL);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPass());
            preparedStatement.setBoolean(4, user.isActiveFlag());
            preparedStatement.setString(5, user.getId());
            return preparedStatement;
        } catch (SQLException e) {
            throw new RepositoryException("Repository error: ", e);
        }
    }

    @Override
    protected IUser getEntity(ResultSet resultSet) {
        IUser entity = new User();
        prepareUserInfo(entity, resultSet);
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

    public IUserRoles getUserRolesByLogin(String login) {
        try {
            IUserRoles userRoles = new UserRoles();
            List<IRole> listRoles = new ArrayList<>();

            PreparedStatement preparedStatement = getConnection().prepareStatement(USER_ROLES_SQL);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                IRole role = new Role();
                role.setName(resultSet.getString("role_name"));
                role.setId(resultSet.getString("role_id"));
                listRoles.add(role);
                if (userRoles.getId() == null) {
                    prepareUserInfo(userRoles, resultSet);
                }
            }

            userRoles.setRoles(listRoles);
            return userRoles;
        } catch (SQLException e) {
            throw new RepositoryException("Repository error: ", e);
        }
    }

    private void prepareUserInfo(IUser user, ResultSet resultSet) {
        try {
            user.setId(resultSet.getString("user_id"));
            user.setName(resultSet.getString("user_name"));
            user.setLogin(resultSet.getString("login"));
            user.setPass(resultSet.getString("pass"));
            user.setActiveFlag(resultSet.getBoolean("active_flag"));
        } catch (SQLException e) {
            throw new RepositoryException("Repository error: ", e);
        }
    }
}
