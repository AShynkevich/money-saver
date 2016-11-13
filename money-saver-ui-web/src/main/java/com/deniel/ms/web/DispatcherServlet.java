package com.deniel.ms.web;

import java.io.IOException;
import java.text.MessageFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by DenielNote on 13.11.2016.
 */
public class DispatcherServlet extends HttpServlet{
    private static final String WEBINF_FMT = "/WEB-INF/jsp/{0}.jsp";
    private static final String HELLO_PATH = "app/hello";
    private static final String ROOT_PATH = "/app";

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String address = req.getRequestURI().substring(req.getContextPath().length());

        if (ROOT_PATH.equals(address)) {
            performForward(HELLO_PATH, req, resp);
        } else {
            resp.sendRedirect("http://google.com");
        }
    }

    private void performForward (String address, HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
        req.getRequestDispatcher(MessageFormat.format(WEBINF_FMT, address)).forward(req, resp);
    }
}
