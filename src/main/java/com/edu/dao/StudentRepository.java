package com.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.entity.Student;
import com.edu.entity.Teacher;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
