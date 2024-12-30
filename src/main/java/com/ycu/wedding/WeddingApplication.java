package com.ycu.wedding;

import com.ycu.wedding.pojo.User;
import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
// @SpringBootApplication 注解有什么用？点进去看子注解。
@MapperScan("com.ycu.wedding.mapper")
public class WeddingApplication {

    private static final Logger log = LogManager.getLogger(WeddingApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(WeddingApplication.class, args);
        log.error("Spring Boot Application started!");
        try {
            Thread.sleep(Long.MAX_VALUE);  // 阻塞，保持应用运行
        } catch (InterruptedException e) {
            log.error("Application interrupted", e);
        }
    }

    // 在容器完全初始化后调用这个方法
    @PostConstruct
    public void init() {

        log.error("Initializing @PostConstruct method...");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        log.error("\nqqq,begin: " + formattedDateTime + "\n" + 0);

    }
}
