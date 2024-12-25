package com.ycu.wedding.controller;

import com.ycu.wedding.pojo.ApiResponse;
import com.ycu.wedding.pojo.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/marry/hello")
public class Hello {
//    private static final Logger log = LogManager.getLogger(Hello.class);

    @GetMapping("/test")
    public String hello() {
//        log.error("qqq,you are in!");
        return "Hello11111111";
    }
}
