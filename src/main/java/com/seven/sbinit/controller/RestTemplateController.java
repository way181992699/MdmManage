package com.seven.sbinit.controller;

import com.seven.sbinit.util.ResEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author:July 2022/7/5
 * 初始化controller
 */
@RestController
@RequestMapping("/rest")
public class RestTemplateController extends ResEntity {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/baidu")
    public ResEntity<String> restTemplateTest() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("https://www.baidu.com/", String.class);
        return responseSuccess(forEntity.getStatusCode().value(), forEntity.getBody());
    }


}
