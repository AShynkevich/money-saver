package com.deniel.ms.repository.sql.jdbc.user;

import com.deniel.ms.domain.user.IUser;
import com.deniel.ms.repository.sql.jdbc.CrudJdbc;
import com.deniel.ms.user.IUserRepository;

import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * Created by DenielNote on 01.11.2016.
 */
public class UserRepository extends CrudJdbc<IUser> implements IUserRepository {
    private static final String CREATE_SQL = "INSERT INTO users values(?, ?, ?, ?, now(), now(), true)";

    @Override
    public PreparedStatement getCreatePreparedStatement(IUser entity) throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement(CREATE_SQL);
        preparedStatement.setString(1, entity.getId());
        preparedStatement.setString(2, entity.getName());
        preparedStatement.setString(3, entity.getLogin());
        preparedStatement.setString(4, entity.getPass());
        return preparedStatement;
    }
}
