package main.java.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJdbc {


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://127.0.0.1:3306/db1";
        String userName = "root";
        String pwd = "1234";

        //1 注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2 获取链接
        Connection connection;
        connection = DriverManager.getConnection(url, userName, pwd);

        //3 定义sql
        String sql = "update account set money = 2000 where id = 1";

        //4 获取执行sql的对象 Statement
        Statement statement = connection.createStatement();

        //5 执行sql
        int count = statement.executeUpdate(sql);

        //6 输出结果
        System.out.println(count);

        //7 释放资源
        statement.close();
        connection.close();
    }

}
