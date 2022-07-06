package com.seven.sbinit.mysql;

import com.seven.sbinit.bean.StudentMysql;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMysqlRepository extends JpaRepository<StudentMysql, Long> {

}
