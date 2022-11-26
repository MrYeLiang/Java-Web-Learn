package com.test;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    List<Brand> selectAll();

    Brand selectById(int id);

    List<Brand> selectByCondition(@Param("status") int status,
                                  @Param("companyName") String companyName,
                                  @Param("brandName") String brandName);

    List<Brand> selectByCondition(Map map);

    List<Brand> selectByCondition(Brand map);

    int add(Brand brand);

    int update(Brand brand);

    void deleteById(int id);

    void deleteByIds(int[] ids);
}
