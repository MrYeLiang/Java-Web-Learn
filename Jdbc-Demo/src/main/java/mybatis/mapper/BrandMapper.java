package main.java.mybatis.mapper;

import main.java.Brand;

import java.util.List;

public interface BrandMapper {
    List<Brand> selectAll();

    User selectById(int id);
}
