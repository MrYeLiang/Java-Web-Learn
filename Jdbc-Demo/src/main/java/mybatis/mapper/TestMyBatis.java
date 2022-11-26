package main.java.mybatis.mapper;

import javax.annotation.Resources;
import java.io.InputStream;

public class TestMyBatis {
    public static void main(String[] args) {
        testSelectAll();
    }

    public static void testSelectAll() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.class.getResourceAsStream(resource);
    }
}
