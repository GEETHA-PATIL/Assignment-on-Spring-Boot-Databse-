package com.quinbay.dependencyInjection2.config;

import com.quinbay.dependencyInjection2.dto.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.Jedis;

@Configuration
public class ApplicationConfig {
    @Bean
    JedisConnectionFactory jedisConnectionFactory(){
        JedisConnectionFactory jedisConnFactory =new JedisConnectionFactory();
        jedisConnFactory.setHostName("localhost");
        jedisConnFactory.setPort(6379);
        return jedisConnFactory;
    }


    @Bean
    public RedisTemplate<String,Student> redisTemplate()
    {
        RedisTemplate<String,Student> template=new RedisTemplate<String, Student>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        return template;
    }

}
