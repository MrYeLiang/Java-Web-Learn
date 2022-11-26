package main.java.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 测试事务管理
 */
public class TestJdbcCommit {
    public static void main(String[] args) throws Exception {
        //1 注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2 获取连接
        String url = "jdbc:mysql:///db1?useSSL = false";
        String useName = "root";
        String passWord = "1234";

        Connection connection = DriverManager.getConnection(url, useName, passWord);

        //3 定义sql
        String sql1 = "update account set money = 3000 where id = 1";
        String sql2 = "update account set money = 3000 where id = 2";

        //4 获取执行sql对象Statement
        Statement statement = connection.createStatement();

        try {
            connection.setAutoCommit(false);
            //5 执行sql
            int count1 = statement.executeUpdate(sql1);//受影响的行数

            System.out.println(count1);

//            int i = 3 / 0;//手动加错误
            int count2 = statement.executeUpdate(sql2);
            System.out.println(count2);

            /* ==============  提交事务  ===============*/
            connection.commit();
        } catch (Exception e) {
            /* ===================== 回滚事务 =======================*/
            connection.rollback();
            e.printStackTrace();
        }


        //6 释放资源
        statement.close();
        connection.close();
    }
}
