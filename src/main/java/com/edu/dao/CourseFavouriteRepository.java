package com.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.entity.Course;
import com.edu.entity.CourseFavourite;

public interface CourseFavouriteRepository extends JpaRepository<CourseFavourite, Integer> {

	List<CourseFavourite> findByStudentId(Integer id);
	
}
