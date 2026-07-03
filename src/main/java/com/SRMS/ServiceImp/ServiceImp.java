package com.SRMS.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SRMS.Entity.StudentEntity;
import com.SRMS.Repository.StudentRepository;
import com.SRMS.Service.StudentService;

@Service
public class ServiceImp implements StudentService {

    @Autowired
    private StudentRepository studentRepository;  

    @Override
    public List<StudentEntity> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public StudentEntity saveStudent(StudentEntity student) {  
        return studentRepository.save(student);  
    }

    @Override
    public StudentEntity getById(int id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

	@Override
	public void deleteById(int id) {
		studentRepository.deleteById(id);
		 
		
		
	}
    
}