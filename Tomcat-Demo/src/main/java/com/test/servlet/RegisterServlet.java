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

@WebServlet(urlPatterns = "/registerServlet")
public class RegisterServlet extends HttpServlet {
    private String TAG = getClass().getSimpleName();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(TAG + ": doGet() ---> ");

        //请求数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        username = new String(username.getBytes("ISO-8859-1"), "UTF-8");

        User userRegister = new User();
        userRegister.setUsername(username);
        userRegister.setPassword(password);

        //创建UserMapper
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //查询本地user是否存在
        User user = userMapper.selectByUsername(username);
        resp.setContentType("text/html;charset=utf-8");
        if (user == null) {
            userMapper.add(userRegister);
            sqlSession.commit();
            sqlSession.close();
            resp.getWriter().write("注册成功!");
        } else {
            resp.getWriter().write("用户名已存在!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(TAG + ": doPost() ---> ");
        this.doGet(req, resp);
    }
}
