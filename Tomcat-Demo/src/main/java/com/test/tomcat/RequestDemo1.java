package com.test.tomcat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/req1")
public class RequestDemo1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = req.getQueryString();
        System.out.println(result);

        String params = "";
        String method = req.getMethod();
        if ("GET".equals(method)) {
            params = req.getQueryString();
        } else if("POST".equals(method)) {
            BufferedReader reader = req.getReader();
            params = reader.readLine();
        }
        System.out.println(params);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        BufferedReader bufferedReader = req.getReader();
//        String line = bufferedReader.readLine();
//        System.out.println(line);
        doGet(req, resp);
    }

}
