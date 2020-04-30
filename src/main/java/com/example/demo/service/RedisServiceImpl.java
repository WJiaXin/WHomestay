package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;


public class RedisServiceImpl implements RedisService{
    @Autowired
    RedisTemplate redisTemplate;
    /**
     * 存储数据
     *
     * @param key
     * @param value
     */
    @Override
    public void set(String key, String value) {
           redisTemplate.opsForValue().set(key,value);
    }

    /**
     * 获取数据
     *
     * @param key
     */
    @Override
    public String get(String key) {
          return (String) redisTemplate.opsForValue().get(key);
    }

    /**
     * 设置超期时间
     *
     * @param key
     * @param expire
     */
    @Override
    public boolean expire(String key, long expire) {
        return redisTemplate.expire(key,60,TimeUnit.SECONDS);
    }

    /**
     * 删除数据
     *
     * @param key
     */
    @Override
    public void remove(String key) {
     redisTemplate.delete(key);
    }

    /**
     * 自增操作
     *
     * @param key
     * @param delta 自增步长
     */
    @Override
    public Long increment(String key, long delta) {
        return redisTemplate.opsForValue().increment(key,delta);
    }
}
