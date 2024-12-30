package com.ycu.wedding.controller;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/marry/hello")
public class Hello {
//    private static final Logger log = LogManager.getLogger(Hello.class);

    @GetMapping("/test")
    public String hello() {
//        log.error("qqq,you are in!");
        return "Hello111111112";
    }
}
