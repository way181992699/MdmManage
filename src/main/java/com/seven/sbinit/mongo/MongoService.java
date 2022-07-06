package com.seven.sbinit.mongo;

import com.seven.sbinit.bean.StudentMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoService {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private StudentRepository studentRepository;

    public void save() {
        StudentMongo studentMongo = new StudentMongo("july", "18");
        mongoTemplate.save(studentMongo);
    }

    public List<StudentMongo> getStudent() {
        List<StudentMongo> all = mongoTemplate.findAll(StudentMongo.class);
        return all;
    }

    public StudentMongo queryById(String id) {
        StudentMongo all = mongoTemplate.findById(id, StudentMongo.class);
        return all;
    }

    public void delById(String id) {
        StudentMongo all = mongoTemplate.findById(id, StudentMongo.class);
        if (all != null) {
            studentRepository.delete(all);
        }

    }

}
