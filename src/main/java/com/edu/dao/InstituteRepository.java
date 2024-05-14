package com.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.entity.Institute;
import com.edu.entity.Teacher;

@Repository
public interface InstituteRepository extends JpaRepository<Institute, Integer> {

}
