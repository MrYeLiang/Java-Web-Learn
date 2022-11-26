package main.java;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TestBrand {
    public static void main(String[] args) throws Exception {
//        testAdd();
//        testUpdate();
        testDelete();
        testSelectAll();
    }

    public static void testSelectAll() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("Jdbc-Demo/src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        String sql = "select * from tb_brand;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        Brand brand = null;
        List<Brand> brandList = new ArrayList<>();
        while(resultSet.next()) {
            brand = new Brand();
            brand.setId(resultSet.getInt("id"));
            brand.setBrandName(resultSet.getString("brand_name"));
            brand.setCompanyName(resultSet.getString("company_name"));
            brand.setOrdered(resultSet.getInt("ordered"));
            brand.setDescription(resultSet.getString("description"));
            brand.setStatus(resultSet.getInt("status"));
            brandList.add(brand);
        }

        System.out.println(brandList);
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

    public static void testAdd() throws Exception {
        String brandName = "比亚迪";
        String companyName = "比亚迪车业";
        int ordered = 300;
        String description = "都是电车干就完了";
        int status = 1;

        Properties properties = new Properties();
        properties.load(new FileInputStream("Jdbc-Demo/src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        String sql = "insert into tb_brand(brand_name, company_name, ordered, description, status) values(?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, brandName);
        preparedStatement.setString(2, companyName);
        preparedStatement.setInt(3, ordered);
        preparedStatement.setString(4, description);
        preparedStatement.setInt(5, status);

        int count = preparedStatement.executeUpdate();
        System.out.println("count = " + count);

        preparedStatement.close();
        connection.close();
    }

    public static void testUpdate() throws Exception {
        String brandName = "比亚迪";
        String companyName = "比亚迪车业";
        int ordered = 30;
        String description = "四个车轱辘的车企";
        int status = 1;
        int id = 4;

        Properties properties = new Properties();
        properties.load(new FileInputStream("Jdbc-Demo/src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        String sql = "update tb_brand\n" +
                "set brand_name = ?,\n" +
                "company_name = ?,\n" +
                "ordered = ?,\n" +
                "description = ?,\n" +
                "status = ?\n" +
                "where id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, brandName);
        preparedStatement.setString(2, companyName);
        preparedStatement.setInt(3, ordered);
        preparedStatement.setString(4, description);
        preparedStatement.setInt(5, status);
        preparedStatement.setInt(6, id);

        int count = preparedStatement.executeUpdate();
        System.out.println("count = " + count);

        preparedStatement.close();
        connection.close();
    }

    public static void testDelete() throws Exception {
        int id = 4;

        Properties properties = new Properties();
        properties.load(new FileInputStream("Jdbc-Demo/src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        String sql = "delete from tb_brand where id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, id);

        int count = preparedStatement.executeUpdate();
        System.out.println("count = " + count);

        preparedStatement.close();
        connection.close();
    }


}
