package com.seven.sbinit.mongo;

import com.seven.sbinit.bean.StudentMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<StudentMongo, Long> {

}
