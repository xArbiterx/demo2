package com.example.demo2.service.impl;

import com.example.demo2.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService {

    private RedisServiceImpl(StringRedisTemplate stringRedisTemplate){
        this.stringRedisTemplate = stringRedisTemplate;
    }

    private final StringRedisTemplate stringRedisTemplate;

    @Override
    public void setValue(String key, String value) {
        ValueOperations<String, String> vo = stringRedisTemplate.opsForValue();
        vo.set(key, value);
        stringRedisTemplate.expire(key, 24, TimeUnit.HOURS); // 这里指的是24小时后失效
    }

    @Override
    public Object getValue(String key) {
        ValueOperations<String, String> vo = stringRedisTemplate.opsForValue();
        return vo.get(key);
    }

}
