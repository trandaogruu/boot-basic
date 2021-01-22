package com.example.demo.repository;

import com.example.demo.model.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Integer> {


    @Query("SELECT s FROM StudentEntity s WHERE s.accountName = :accountName ")
    StudentEntity findStudentByAccountName(@Param("accountName")String accountName);
}
