package com.xxxx.server.config.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @ClassName: RedisConfig
 * @Description: TODO
 * @author: solfeng
 * @date: 2021/7/8  18:03
 */
@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String,Object> redisTemplate(LettuceConnectionFactory connectionFactory){
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        //String类型 key序列化
        template.setKeySerializer(new StringRedisSerializer());
        //String类型 value序列化
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        //Hash类型 key序列化
        template.setHashKeySerializer(new StringRedisSerializer());
        //Hash类型 value序列化
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setConnectionFactory(connectionFactory);
        return template;
    }
}
