package com.deniel.ms.web.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by DenielNote on 16.11.2016.
 */
public interface IAction {
    String doAction(HttpServletRequest request, HttpServletResponse response);
}
