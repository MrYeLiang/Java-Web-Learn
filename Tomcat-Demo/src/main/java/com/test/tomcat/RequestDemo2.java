package com.test.tomcat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Request参数获取及中文乱码问题解决
 */
@WebServlet("/req2")
public class RequestDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得所有参数
        Map<String, String[]> map = req.getParameterMap();
        for (String key : map.keySet()) {
            System.out.println("key ---> "  + key);
            String [] values = map.get(key);

            for (String value : values) {
                System.out.println("value ---> " + value);
            }

            System.out.println();
        }

        //获得单个参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("单个参数值 username = " + username + ", password = " + password);

        //数组值
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby: hobbies) {
            System.out.println(hobby);
        }

        //=================乱码问题
        //post方式设置解码格式
//        req.setCharacterEncoding("UTF-8");

        //get/post设置解码格式
        username = new String(username.getBytes("ISO-8859-1"), "UTF-8");
        System.out.println("username = " + username);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
