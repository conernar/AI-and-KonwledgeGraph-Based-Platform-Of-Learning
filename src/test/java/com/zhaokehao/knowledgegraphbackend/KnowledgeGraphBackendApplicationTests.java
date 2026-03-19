package com.zhaokehao.knowledgegraphbackend;

import com.zhaokehao.knowledgegraphbackend.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KnowledgeGraphBackendApplicationTests {
    @Autowired//根据类寻找对象
    private UserMapper userMapper;
    //根据名称寻找对象
//    @Resource
//    private UserMapper userMapper;
    @Test
    void contextLoads() {
    }

}
