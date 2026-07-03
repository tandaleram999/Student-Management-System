package com.SRMS.Service;

import java.util.List;

import com.SRMS.Entity.StudentEntity;

 

public interface StudentService {
	public List<StudentEntity>getAllStudent();
	public StudentEntity saveStudent(StudentEntity student);
	public StudentEntity getById(int id);
	public void deleteById(int id);
	 
	 

}
