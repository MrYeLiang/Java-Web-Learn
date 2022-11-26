package com.test.tomcat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/resp1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //转发
//        resp.setStatus(302);
//        resp.setHeader("location", "/tomcat-demo/resp2");
//        System.out.println("Resp1 doGet() ");

        //响应字符数据
        resp.setContentType("text/html, charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write("hello");

        //响应字节数据
//        FileInputStream stream = new FileInputStream("/Users/yl/Desktop/image.png");
//        ServletOutputStream os = resp.getOutputStream();
//        byte[] buff = new byte[1024];
//        int len = 0;
//        while ((len = stream.read(buff)) != -1) {
//            os.write(buff, 0, len);
//        }

        //简化形式
//        IOUtils.copy(stream, os);
//
//        stream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
