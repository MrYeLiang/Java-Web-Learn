package com.test.servlet;

import com.test.mapper.UserMapper;
import com.test.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    private String TAG = getClass().getSimpleName();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(TAG + ": doGet() ---> ");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.select(username, password);
        sqlSession.close();

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if (user != null) {
            writer.write("登录成功");
        } else {
            writer.write("登录失败");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(TAG + ": doPost() ---> ");
        this.doGet(req, resp);
    }
}
