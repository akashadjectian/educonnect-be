package com.edu.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edu.entity.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Integer>{

}
