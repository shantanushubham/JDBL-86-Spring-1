package org.geeksforgeeks.jdbl86.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    private final StringRedisTemplate redisTemplate;

    public RedisService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void save(String key, String value) {
        this.redisTemplate.opsForValue().set(key, value, 5, TimeUnit.MINUTES);
    }

    public String get(String key) {
        return this.redisTemplate.opsForValue().get(key);
    }

    public void delete(String key) {
        this.redisTemplate.delete(key);
    }
}
