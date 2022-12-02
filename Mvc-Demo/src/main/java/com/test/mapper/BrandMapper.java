package com.test.mapper;

import com.test.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandMapper {
    List<Brand> selectAll();

    @Insert("insert into tb_brand values(null, #{brandName}, #{companyName}," +
            " #{ordered}, #{description}, #{status})")
    void add(Brand brand);

    @Select("select * from tb_brand where id = #{id}")
    @ResultMap("brandResultMap")
    Brand selectById(int id);
}
