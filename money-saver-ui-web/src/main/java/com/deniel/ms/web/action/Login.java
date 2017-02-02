package com.deniel.ms.web.action;

import com.deniel.ms.web.manager.IAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login implements IAction {

    @Override
    public String doAction(HttpServletRequest request, HttpServletResponse response) {
        return "app/login";
    }
}
