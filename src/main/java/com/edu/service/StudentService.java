package com.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.StudentRepository;
import com.edu.entity.Institute;
import com.edu.entity.Student;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	
	// for saving the Student
	public boolean saveStudent(Student student) {	
		if(student != null) {
			studentRepository.save(student);
			return true;
		}
		return false;
	}

	//for getting a single student
	public Student getOneStudent(Integer id) {
			Student student = studentRepository.findById(id).get();
			if(student!=null) {
				return student;
			}
			return null;
	}

	//for getting all studentlist 
	public List<Student> getAllStudent(){		
		List<Student> studentlist = (List<Student>)studentRepository.findAll(); 
		return studentlist;
	}

	//for delete the student
	public boolean deleteStudent(Integer id) {
		if(id!=null) {
			this.studentRepository.deleteById(id);
			return true;
		}
		return false;
	}

	//for update the student
	public Boolean updateStudent(Student student) {
		if(student != null) {
			studentRepository.save(student);
			return true;
		}
		return false;
	}
	
	

public Student getByUserName(String username){		
	Student student = studentRepository.findByUsername(username); 
	return student;
}
	
}
