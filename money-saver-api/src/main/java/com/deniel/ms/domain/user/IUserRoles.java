package com.deniel.ms.domain.user;

import java.util.List;

/**
 * Created by DenielNote on 10.11.2016.
 */
public interface IUserRoles extends IUser {
    void setRoles (List<IRole> rolesList);

    List<IRole> getRoles ();
}
