package com.deniel.ms.domain.user;

import com.deniel.ms.domain.StoredObject;

/**
 * Created by DenielNote on 01.11.2016.
 */
public class User extends StoredObject implements IUser {
    private String login ;
    private String pass;
    private boolean activeFlag;

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String getPass() {
        return pass;
    }

    @Override
    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public boolean isActiveFlag() {
        return activeFlag;
    }
    
    @Override
    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
}
