package com.test.mapper;

import com.test.pojo.Brand;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface BrandMapper {
    List<Brand> selectAll();

    @Insert("insert into tb_brand values(null, #{brandName}, #{companyName}," +
            " #{ordered}, #{description}, #{status})")
    void add(Brand brand);
}
