package com.test.tomcat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//1 匹配多个
//@WebServlet(urlPatterns = {"/demo3", "/demo4"})

//2 精确匹配
//@WebServlet(urlPatterns = "/api/select")

//3 目录匹配
//@WebServlet(urlPatterns = "/api/*")

//4 任意匹配
//@WebServlet(urlPatterns = "/*")
public class Servlet7 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet7 doGet");
    }
}
