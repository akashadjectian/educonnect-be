package com.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.CourseFavouriteRepository;
import com.edu.entity.CourseFavourite;
import com.edu.entity.Student;

@Service
public class CourseFavouriteService {

	@Autowired
	private CourseFavouriteRepository courseFavouriteRepository;

	public List<CourseFavourite> getAllCourses(Integer id) {
		return this.courseFavouriteRepository.findByStudentId(id);
	}

	// for add course
	public boolean add(CourseFavourite courseFavourite) {
		if (courseFavourite != null) {
			courseFavouriteRepository.save(courseFavourite);
			return true;
		}
		return false;
	}

	// for delete
	public boolean delete(Integer id) {
		if (id != null) {
			this.courseFavouriteRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
