package com.jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/demo1")
public class ServletDemo1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletDemo1 doGet");
        List<Brand> brandList = new ArrayList();
        brandList.add(new Brand(1, "华为", "华为", 200, "5G厂商", 1));
        brandList.add(new Brand(2, "比亚迪", "比亚迪", 300, "国产电车", 1));
        brandList.add(new Brand(3, "茅台", "茅台", 400, "白酒酱香", 1));

        req.setAttribute("brands", brandList);
        req.setAttribute("status", 111);

        System.out.println(req.getAttribute("brands"));

        req.getRequestDispatcher("/el-demo.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
