package com.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserMapperTest {
    @Test
    public void testSelect() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.selectAll();
        System.out.println("userList = " + userList);
        sqlSession.close();
    }

    @Test
    public void testSelectAnnotion() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectBy(2);
        System.out.println("user = " + user);
        sqlSession.close();
    }

    @Test
    public void testSelectAllBrand() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brandList = brandMapper.selectAll();
        System.out.println("brandList = " + brandList);
        Brand brand = brandMapper.selectById(2);
        System.out.println("brand = " + brand);

        sqlSession.close();
    }

    @Test
    public void testByCondition() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        String companyName = "%" + "小米" + "%" ;
        String brandName = "%" + "小米" + "%" ;

        List<Brand> brandList = brandMapper.selectByCondition(1, companyName, brandName);
        System.out.println("first way brandList = " + brandList);

//        Brand brand = new Brand();
//        brand.setStatus(1);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);
//        brand.setStatus(1);
//        brandList = brandMapper.selectByCondition(brand);
//        System.out.println("second way brandList = " + brandList);
//
//        Map map = new HashMap<>();
//        map.put("status", 1);
//        map.put("companyName", companyName);
//        map.put("brandName", brandName);
//        brandList = brandMapper.selectByCondition(map);

        System.out.println("third way brandList = " + brandList);
        sqlSession.close();
    }

    @Test
    public void testAdd() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        int status = 1;
        String companyName = "上汽大众有限公司";
        String brandName = "大众";
        String description = "舒服的开车体验";
        int ordered = 40;

        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        System.out.println("id = " + brand.getId());
        brandMapper.add(brand);
        System.out.println("id = " + brand.getId());
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        int status = 1;
        String companyName = "奥迪有限公司";
        String brandName = "Audi";
        String description = "高端商务车";
        int ordered = 50;
        int id = 5;

        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);
        brand.setId(id);

        int count  = brandMapper.update(brand);
        System.out.println("count = " + count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDelete() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        int id = 6;
        brandMapper.deleteById(id);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteMulti() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        int[] ids = {6, 7, 8};
        brandMapper.deleteByIds(ids);

        sqlSession.commit();
        sqlSession.close();
    }
}
