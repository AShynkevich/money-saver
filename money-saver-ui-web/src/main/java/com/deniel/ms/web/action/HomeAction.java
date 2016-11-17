package com.deniel.ms.web.action;

import com.deniel.ms.web.manager.IAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by DenielNote on 16.11.2016.
 */
public class HomeAction implements IAction {
    @Override
    public String doAction(HttpServletRequest request, HttpServletResponse response) {
        return "app/homepage";
    }
}
