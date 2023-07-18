package com.example.iniflex.project.test.repositories;

import com.example.iniflex.project.test.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{


    @Query(value = "SELECT SUM(SALARY) FROM TB_EMPLOYEE", nativeQuery = true)
    double sumSalary();

    @Query(value = "SELECT NAME_PERSON, TRUNC(SALARY/1212, 2) FROM TB_EMPLOYEE",nativeQuery = true)
    List<String> minSalary();

    @Transactional
    @Modifying
    @Query(value = "UPDATE TB_EMPLOYEE SET SALARY = SALARY + (SALARY*0.1)", nativeQuery = true)
    int updateSalary();

    @Query(value = "SELECT * FROM TB_EMPLOYEE WHERE EXTRACT(MONTH FROM (DT_BIRTH)) = 10 OR EXTRACT(MONTH FROM (DT_BIRTH)) = 12", nativeQuery = true)
    List<Employee> dateOfBirth();

    @Query(value = "SELECT * FROM TB_EMPLOYEE ORDER BY NAME_PERSON", nativeQuery = true)
    List<Employee> nameAllOrder();

    @Query(value = "SELECT NAME_PERSON, EXTRACT(YEAR FROM(SELECT CURRENT_DATE() FROM DUAL))- EXTRACT(YEAR FROM (DT_BIRTH)) AS AGE FROM TB_EMPLOYEE WHERE NAME_PERSON = 'CAIO'", nativeQuery = true)
    String olderEmployee();

    @Query(value = "SELECT ID_PERSON, DT_BIRTH, NAME_PERSON, FUNCTION, SALARY FROM TB_EMPLOYEE GROUP BY FUNCTION, ID_PERSON", nativeQuery = true)
    List<Employee> groupAll();

}

