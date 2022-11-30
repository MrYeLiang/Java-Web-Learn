package com.test.mapper;

import com.test.pojo.Brand;

import java.util.List;

public interface BrandMapper {
//    @Select("select * from tb_brand")
//    @ResultMap("brandResultMap")
    List<Brand> selectAll();
}
