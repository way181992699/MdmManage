package com.seven.sbinit.mysql;

import com.seven.sbinit.bean.StudentMysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MysqlService {
    @Autowired
    StudentMysqlRepository studentMysqlRepository;

    public void save() {
        List<StudentMysql> studentMysqlList = new ArrayList<>();
        Random random = new Random(100);

        for (int i = 1; i <= 10; i++) {
            UUID uuid = UUID.randomUUID();

            StudentMysql july = new StudentMysql(null, "july" + uuid, random.nextInt() + "", new Date());
            studentMysqlList.add(july);
        }
        studentMysqlRepository.saveAll(studentMysqlList);
    }

    public List<StudentMysql>  queryAll() {
        List<StudentMysql> all = studentMysqlRepository.findAll();
        return all;

    }

    public StudentMysql  getById(long id) {
        Optional<StudentMysql> byId = studentMysqlRepository.findById(id);
        StudentMysql studentMysql = byId.get();
        return studentMysql;
    }
    public void delById(long id) {
        studentMysqlRepository.deleteById(id);
    }
}
