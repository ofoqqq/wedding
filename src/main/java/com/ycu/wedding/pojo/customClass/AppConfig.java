package com.ycu.wedding.pojo.customClass;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.client.RestTemplate;


@Configuration
public class AppConfig {

//    WeChatApiClient类中，RestTemplate不能使用@Autowired注解，不是默认的Bean
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    // RedisTemplate 用于操作 Redis 数据
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        // 设置 key 序列化器为 StringRedisSerializer，value 序列化器为 JdkSerializationRedisSerializer
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new StringRedisSerializer()); // 这里根据需要设置 value 的序列化方式
        return template;
    }

    // CacheManager 用于管理缓存
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager
                .builder(connectionFactory);
        return builder.build();
    }
}
