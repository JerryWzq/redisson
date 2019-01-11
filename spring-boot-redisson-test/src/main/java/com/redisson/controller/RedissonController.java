package com.redisson.controller;

import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedissonController {

    @Autowired
    RedissonClient redissonClient;

    @RequestMapping("/test")
    public String test(@RequestParam String key){
        RBucket<String> bucket = redissonClient.getBucket(key);
        return bucket.get();
    }

}