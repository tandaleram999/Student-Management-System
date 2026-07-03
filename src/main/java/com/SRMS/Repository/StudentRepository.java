package com.SRMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SRMS.Entity.StudentEntity;

 
@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer > {

}
