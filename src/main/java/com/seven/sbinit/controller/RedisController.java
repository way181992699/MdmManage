package com.seven.sbinit.controller;

import com.seven.sbinit.bean.StudentMysql;
import com.seven.sbinit.redis.RedisService;
import com.seven.sbinit.util.ResEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author:July 2022/7/5
 * 初始化controller
 */
@RestController
@RequestMapping("/redis")
public class RedisController extends ResEntity {

    @Autowired
    RedisService redisService;

    @PostMapping("/demo")
    public ResEntity<List<StudentMysql>> operation() {
        redisService.demonstration();
        return responseSuccess();
    }

    @GetMapping("/one")
    public ResEntity<StudentMysql> mysqlGetOne(Long id) {

        return responseSuccess();
    }

    @DeleteMapping("/del")
    public ResEntity<String> redisDel(String key) {
        redisService.delKey(key);
        return responseSuccess();
    }
    @DeleteMapping("/delAll")
    public ResEntity<String> redisDelAll() {
        redisService.delAll();
        return responseSuccess();
    }
}
