package com.test.service;

import com.test.mapper.BrandMapper;
import com.test.pojo.Brand;
import com.test.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandService {
    SqlSessionFactory factory  = SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<Brand> selectAll() {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = mapper.selectAll();
        System.out.println("brands = " + brands);
        sqlSession.close();
        return brands;
    }

    public void add(Brand brand) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.add(brand);
        sqlSession.commit();
        sqlSession.close();
    }

    public Brand selectById(int id) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = mapper.selectById(id);
        sqlSession.commit();
        sqlSession.close();

        return brand;
    }

    public void update(Brand brand) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        System.out.println("update brand = " + brand);
        mapper.update(brand);
        sqlSession.commit();
        sqlSession.close();
    }

}
