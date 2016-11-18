package com.deniel.ms.web.servlet;

import com.deniel.ms.web.manager.ActionManager;
import com.deniel.ms.web.manager.IAction;

import java.io.IOException;
import java.text.MessageFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by DenielNote on 13.11.2016.
 */
public class DispatcherServlet extends HttpServlet {
    private static final String WEBINF_FMT = "/WEB-INF/jsp/{0}.jsp";
    private static final String APP_PATH = "/app/";

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            performForward(getAction(req, resp), req, resp);
        } catch (Exception e) {
            resp.sendRedirect("http://google.com");
        }
    }

    private void performForward(String address, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(MessageFormat.format(WEBINF_FMT, address)).forward(req, resp);
    }

    public String getAction(HttpServletRequest req, HttpServletResponse resp) {
        String reqUrl = req.getRequestURI();
        String action = reqUrl.substring(reqUrl.indexOf(APP_PATH) + APP_PATH.length());
        return ActionManager.findAction(action).doAction(req, resp);
    }
}
