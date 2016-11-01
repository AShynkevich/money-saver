package com.deniel.ms.repository.sql.jdbc.user;

import com.deniel.ms.domain.user.IUser;
import com.deniel.ms.repository.sql.jdbc.CrudJdbc;
import com.deniel.ms.user.IUserRepository;

/**
 * Created by DenielNote on 01.11.2016.
 */
public class UserRepository extends CrudJdbc<IUser> implements IUserRepository {
}
