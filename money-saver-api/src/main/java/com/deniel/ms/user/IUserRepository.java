package com.deniel.ms.user;


import com.deniel.ms.domain.user.IUser;
import com.deniel.ms.domain.user.User;
import com.deniel.ms.repository.Crud;

import java.util.List;

/**
 * Created by DenielNote on 01.11.2016.
 */
public interface IUserRepository extends Crud<String, IUser> {
}
