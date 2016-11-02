package com.deniel.ms.domain.user;

import com.deniel.ms.domain.Identifiable;

/**
 * Created by DenielNote on 01.11.2016.
 */
public interface IUser extends Identifiable<String>{
    String getLogin();

    void setLogin(String login);

    String getPass();

    void setPass(String pass);

    boolean isActiveFlag();

    void setActiveFlag(boolean activeFlag);

    String getName();

    void setName(String name);

}
