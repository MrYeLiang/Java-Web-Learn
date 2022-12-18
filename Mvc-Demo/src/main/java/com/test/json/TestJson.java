package com.test.json;

import com.alibaba.fastjson.JSON;
import com.test.pojo.User;

public class TestJson {

    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setUsername("lisi");
        user.setPassword("876");

        String jsonStr = JSON.toJSONString(user);
        System.out.println("jsonStr = " + jsonStr);

        User user2 = JSON.parseObject(jsonStr, User.class);
        System.out.println("user2 = " + user2);

//        jsonStr = {"id":1,"password":"876","username":"lisi"}
//        user2 = User{id=1, username='lisi', password='876'}
    }
}
