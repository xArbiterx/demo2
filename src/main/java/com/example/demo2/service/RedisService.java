package com.example.demo2.service;

import java.util.Map;

public interface RedisService {
    // 加入元素
    void setValue(String key, String value);
    // 获取元素
    Object getValue(String key);

}
