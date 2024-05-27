package com.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.CourseRepository;
import com.edu.dao.InstituteRepository;
import com.edu.entity.Course;
import com.edu.entity.Institute;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private InstituteRepository instituteRepository;
	
	// for saving the Course
	public boolean saveCourse(Course course) {	
		if(course != null) {
			course.setStatus(true);
			courseRepository.save(course);
			return true;
		}
		return false;
	}

	//for getting a single course
	public Course getOneCourse(Integer id) {
			Course course = courseRepository.findById(id).get();
			if(course!=null) {
				return course;
			}
			return null;
	}

	//for getting all courselist 
	public List<Course> getAllCourse(){		
		List<Course> courselist = (List<Course>)courseRepository.findAll(); 
		return courselist;
	}

	//for delete the course
	public boolean deleteCourse(Integer id) {
		if(id!=null) {
			this.courseRepository.deleteById(id);
			return true;
		}
		return false;
	}

	//for update the course
	public Boolean updateCourse(Course course) {
		if(course != null) {
			courseRepository.save(course);
			return true;
		}
		return false;
	}
	
	
	public List<Course> getAllCoursesByInstitute(String username){
		Institute institute = instituteRepository.findByUsername(username);
		List<Course> courselist = courseRepository.findByInstitute(institute); 
		return courselist;
	}
}
