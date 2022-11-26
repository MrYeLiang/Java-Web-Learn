package main.java.test;

import java.sql.*;

public class TestSqlInject {

    //模拟问题
//    public static void main(String[] args) throws Exception {
//        String url = "jdbc:mysql://127.0.0.1:3306/db1";
//        String userName = "root";
//        String pwd = "1234";
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection connection = DriverManager.getConnection(url, userName, pwd);
//        String name = "zhsan";
//        String password = "' or '1' = '1";
//        String sql = "select * from tb_user where username = '"+name + "' and password = '" + password + "'";
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery(sql);
//
//        if (resultSet.next()) {
//            System.out.println("登录成功~");
//        } else {
//            System.out.println("登录失败~");
//        }
//
//        resultSet.close();
//        statement.close();
//        connection.close();
//    }

    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://127.0.0.1:3306/db1";
        String userName = "root";
        String pwd = "1234";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, userName, pwd);
        String name = "zhsan";
        String password = "' or '1' = '1";
        String sql = "select * from tb_user where username = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, name);
        preparedStatement.setString(2, password);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            System.out.println("登录成功~");
        } else {
            System.out.println("登录失败~");
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
