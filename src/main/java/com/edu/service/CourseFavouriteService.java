package com.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.CourseFavouriteRepository;
import com.edu.entity.Course;

@Service
public class CourseFavouriteService {

	@Autowired
	private CourseFavouriteRepository courseFavouriteRepository;
	
	public List<Course> getAllCourses(Integer id){
		return this.courseFavouriteRepository.findByStudentId(id);
	}
	
}

