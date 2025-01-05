package com.ycu.wedding;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WeddingApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(System.currentTimeMillis());
        String a = null;
        System.out.println(String.valueOf(a));
    }

}
