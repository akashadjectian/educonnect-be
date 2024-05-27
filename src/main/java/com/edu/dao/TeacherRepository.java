package com.edu.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edu.entity.Course;
import com.edu.entity.Institute;
import com.edu.entity.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Integer>{
	List<Teacher> findByInstitute(Institute institute);
}
