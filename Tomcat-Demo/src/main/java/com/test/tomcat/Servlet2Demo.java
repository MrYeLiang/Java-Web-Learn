package com.test.tomcat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo2")
public class Servlet2Demo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        System.out.println("method = " + method);

        String path = req.getContextPath();
        System.out.println("path = " + path);

        StringBuffer url = req.getRequestURL();
        System.out.println("url = " + url);

        String uri = req.getRequestURI();
        System.out.println("uri = " + uri);

        String queryString = req.getQueryString();
        System.out.println("queryString = " + queryString);

        String agent = req.getHeader("user-agent");
        System.out.println("agent = " + agent);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");
    }
}
