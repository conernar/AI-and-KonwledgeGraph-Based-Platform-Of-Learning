package com.zhaokehao.knowledgegraphbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@MapperScan("com.zhaokehao.knowledgegraphbackend.mapper")
public class KnowledgeGraphBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(KnowledgeGraphBackendApplication.class, args);
    }

}
