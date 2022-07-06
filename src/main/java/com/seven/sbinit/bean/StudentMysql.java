package com.seven.sbinit.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table()
public class StudentMysql {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //主键生成策略
    Long id;
    @Column(nullable = false, unique = true, length = 200) //非空，唯一，字符长度200
    String name;
    @Column(nullable = false, length = 20)
    String age;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date createTime; //Date 对应Mysql datetime类



}
