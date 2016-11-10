package com.deniel.ms.domain.user;

import java.util.List;

/**
 * Created by DenielNote on 10.11.2016.
 */
public class UserRoles extends User implements IUserRoles {
    private List<IRole> rolesList;

    @Override
    public void setRoles(List<IRole> rolesList) {
        this.rolesList = rolesList;
    }

    @Override
    public List<IRole> getRoles() {
        return rolesList;
    }
}
