package org.geeksforgeeks.jdbl86.controller;

import org.geeksforgeeks.jdbl86.service.RedisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    private final RedisService redisService;

    public RedisController(RedisService redisService) {
        this.redisService = redisService;
    }

    @GetMapping("/{key}")
    public Object readRedis(@PathVariable String key) {
        return this.redisService.get(key);
    }
}
