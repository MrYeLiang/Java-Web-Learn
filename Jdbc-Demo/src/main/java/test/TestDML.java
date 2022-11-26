package main.java.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDML {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://127.0.0.1:3306/db1";
        String userName = "root";
        String pwd = "1234";

        //1 注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2 获取链接
        Connection connection;
        connection = DriverManager.getConnection(url, userName, pwd);

        //3 定义sql
        String sql = "select * from account";

        //4 获取执行sql的对象 Statement
        Statement statement = connection.createStatement();

        //5 执行sql
        ResultSet resultSet = statement.executeQuery(sql);

        //6 输出结果
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            double money = resultSet.getDouble("money");

            System.out.println("id = " + id + ", name = " + name + ", money = " + money);
        }

        //7 释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
