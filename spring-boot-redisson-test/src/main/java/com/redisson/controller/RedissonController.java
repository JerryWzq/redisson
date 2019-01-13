package com.redisson.controller;

import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class RedissonController {

    @Autowired
    RedissonClient redissonClient;

    @RequestMapping("/test")
    public String test(@RequestParam String key){
        //当value的值设置为yes时，获取时会报错
        RBucket<String> bucket = redissonClient.getBucket(key);
        String value = bucket.get();
        return value;
    }
    @RequestMapping("/set")
    public String set(@RequestParam String key, @RequestParam String value){
        RBucket<String> bucket = redissonClient.getBucket(key);
        bucket.set(value, 120, TimeUnit.SECONDS);
        return bucket.get();
    }

}