package com.test;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();

    @Select("select * from tb_user where id = #{id}")
    User selectBy(int id);
}
