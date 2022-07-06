package com.seven.sbinit.controller;

import com.seven.sbinit.bean.StudentMongo;
import com.seven.sbinit.mongo.MongoService;
import com.seven.sbinit.util.ResEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author:July 2022/7/5
 * 初始化controller
 */
@RestController
@RequestMapping("/mongo")
public class MongoController extends ResEntity {

    @Autowired
    MongoService mongoService;

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World!";
    }

    @PostMapping("/save")
    public ResEntity<String> mongoSave() {
        mongoService.save();
        return responseSuccess();
    }

    @PostMapping("/all")
    public ResEntity<StudentMongo> mongoAll() {
        return responseSuccess(mongoService.getStudent());
    }

    @PostMapping("/queryById")
    public ResEntity<StudentMongo> queryById(String id) {
        return responseSuccess(mongoService.queryById(id));
    }

    @DeleteMapping("/del")
    public ResEntity<String> delById(String id) {
        mongoService.delById(id);
        return responseSuccess();
    }

}
