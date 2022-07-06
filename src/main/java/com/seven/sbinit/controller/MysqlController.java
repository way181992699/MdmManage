package com.seven.sbinit.controller;

import com.seven.sbinit.bean.StudentMysql;
import com.seven.sbinit.mysql.MysqlService;
import com.seven.sbinit.util.ResEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author:July 2022/7/5
 * 初始化controller
 */
@RestController
@RequestMapping("/mysql")
public class MysqlController extends ResEntity {

    @Autowired
    MysqlService mysqlService;

    @PostMapping("/save")
    public ResEntity<String> mysqlSave() {
        mysqlService.save();
        return responseSuccess();
    }

    @GetMapping("/all")
    public ResEntity<List<StudentMysql>> mysqlAll() {
        return responseSuccess(mysqlService.queryAll());
    }
    @GetMapping("/one")
    public ResEntity<StudentMysql> mysqlGetOne(Long id ) {
        return responseSuccess(mysqlService.getById(id));
    }
    @DeleteMapping("/del")
    public ResEntity<String> mysqlDel(Long id ) {
        mysqlService.delById(id);
        return responseSuccess();

    }
}
