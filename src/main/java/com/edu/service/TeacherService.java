package com.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.InstituteRepository;
import com.edu.dao.TeacherRepository;
import com.edu.entity.Institute;
import com.edu.entity.Teacher;

@Service
public class TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private InstituteRepository instituteRepository;
	
	// for saving the Teacher
	public boolean saveTeacher(Teacher teacher) {	
		if(teacher != null) {
			teacherRepository.save(teacher);
			return true;
		}
		return false;
	}

	//for getting a single teacher
	public Teacher getOneTeacher(Integer id) {
			Teacher teacher = teacherRepository.findById(id).get();
			if(teacher!=null) {
				return teacher;
			}
			return null;
	}

	//for getting all teacherlist 
	public List<Teacher> getAllTeacher(){	
		System.out.println("wertyuio");
		 List<Teacher> teacherlist = (List<Teacher>) this.teacherRepository.findAll();
		 System.out.println("wertyuio"+teacherlist);
		return teacherlist;
	}

	//for delete the teacher
	public boolean deleteTeacher(Integer id) {
		if(id!=null) {
			this.teacherRepository.deleteById(id);
			return true;
		}
		return false;
	}

	//for update the teacher
	public Boolean updateTeacher(Teacher teacher) {
		if(teacher != null) {
			teacherRepository.save(teacher);
			return true;
		}
		return false;
	}
	
	
	public List<Teacher> getAllTeacherByInstituteUsername(String username){
		Institute institute = instituteRepository.findByUsername(username);
		List<Teacher> teacherlist = teacherRepository.findByInstitute(institute); 
		return teacherlist;
	}
}
