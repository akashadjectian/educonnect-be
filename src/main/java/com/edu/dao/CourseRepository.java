package com.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.entity.Course;
import com.edu.entity.Institute;

public interface CourseRepository extends JpaRepository<Course, Integer> {
	
	List<Course> findByInstitute(Institute institute);
	}
