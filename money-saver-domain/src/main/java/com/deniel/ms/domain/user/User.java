package com.deniel.ms.domain.user;

import com.deniel.ms.domain.Identifiable;
import com.deniel.ms.domain.StoredObject;

/**
 * Created by DenielNote on 01.11.2016.
 */
public class User extends StoredObject implements Identifiable<String>{
    private String login ;
    private String pass;
    private boolean activeFlag;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
}
