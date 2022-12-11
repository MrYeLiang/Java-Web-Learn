package com.test.web;

import com.test.pojo.User;
import com.test.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    private String TAG = getClass().getSimpleName();
    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(TAG + ": doGet() ---> ");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");

        User user = service.login(username, password);

        System.out.println("loginServlet username = " + username + ", password = " + password);

        if (user != null) {
            if ("1".equals(remember)) {
                Cookie c_username = new Cookie("username", URLEncoder.encode(username, "UTF-8"));
                Cookie c_password = new Cookie("password", URLEncoder.encode(password, "UTF-8"));

                int week = 60 * 60 * 24 * 7;
                c_username.setMaxAge(week);
                c_password.setMaxAge(week);

                resp.addCookie(c_username);
                resp.addCookie(c_password);
            }

            HttpSession session = req.getSession();
            session.setAttribute("user", user);

            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath + "/selectAllServlet");
        } else {
            req.setAttribute("login_msg", "用户名或密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(TAG + ": doPost() ---> ");
        this.doGet(req, resp);
    }
}
