package com.ycu.wedding;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @SpringBootApplication 注解有什么用？点进去看子注解。
@MapperScan("com.ycu.wedding.mapper")
public class WeddingApplication {

    private static final Logger log = LogManager.getLogger(WeddingApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WeddingApplication.class, args);
        System.out.printf("111\n");
        log.error("qqq,1");
    }

}
