package com.test.web;

import com.test.pojo.Brand;
import com.test.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
    private BrandService service = new BrandService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setCharacterEncoding("utf-8");

       String id = req.getParameter("id");
       String brandName = req.getParameter("brandName");
       String companyName = req.getParameter("companyName");
       String ordered = req.getParameter("ordered");
       String description = req.getParameter("description");
       String status = req.getParameter("status");

       Brand brand = new Brand();
       brand.setBrandName(brandName);
       brand.setCompanyName(companyName);
       brand.setOrdered(Integer.parseInt(ordered));
       brand.setDescription(description);
       brand.setStatus(Integer.parseInt(status));
       brand.setId(Integer.parseInt(id));

       service.update(brand);

       req.getRequestDispatcher("/selectAllServlet").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
