package com.seven.sbinit.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Student")
public class StudentMongo {
    String id;
    String name;
    String age;

    public StudentMongo(String name, String age) {
        this.name = name;
        this.age = age;
    }
}
