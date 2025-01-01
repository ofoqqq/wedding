package com.ycu.wedding.pojo.customClass;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * WeChatApiClient类中，RestTemplate不能使用@Autowired注解，不是默认的Bean
 */
@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
