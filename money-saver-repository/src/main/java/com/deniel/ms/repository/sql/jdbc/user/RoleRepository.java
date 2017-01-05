package com.deniel.ms.repository.sql.jdbc.user;

import com.deniel.ms.domain.user.IRole;
import com.deniel.ms.domain.user.Role;
import com.deniel.ms.exception.RepositoryException;
import com.deniel.ms.repository.sql.jdbc.ConnectionManager;
import com.deniel.ms.repository.sql.jdbc.CrudJdbc;
import com.deniel.ms.user.IRoleRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by DenielNote on 01.11.2016.
 */
public class RoleRepository extends CrudJdbc<IRole> implements IRoleRepository {
    private static final String TABLE_NAME = "roles";
    private static final String TABLE_FIELD_ID = "role_id";
    private static final String CREATE_SQL = "INSERT INTO roles values(?, ?, now(), now())";
    private static final String UPDATE_SQL = "UPDATE roles SET role_name = ?, where role_id = ?";

    public RoleRepository(ConnectionManager connectionManager) {
        super(connectionManager);
    }

    @Override
    protected PreparedStatement getCreateStatement(IRole role) {
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(CREATE_SQL);
            preparedStatement.setString(1, role.getId());
            preparedStatement.setString(2, role.getName());
            return preparedStatement;
        } catch (SQLException e) {
            throw new RepositoryException("Repository error: ", e);
        }
    }

    @Override
    protected PreparedStatement getUpdateStatement(IRole role) {
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(UPDATE_SQL);
            preparedStatement.setString(1, role.getName());
            preparedStatement.setString(2, role.getId());
            return preparedStatement;
        } catch (SQLException e) {
            throw new RepositoryException("Repository error: ", e);
        }
    }

    @Override
    protected IRole getEntity(ResultSet resultSet) {
        try {
            IRole entity = new Role();
            entity.setId(resultSet.getString("role_id"));
            entity.setName(resultSet.getString("role_name"));
            return entity;
        } catch (SQLException e) {
            throw new RepositoryException("Repository error: ", e);
        }
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
