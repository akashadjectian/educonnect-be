package com.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.entity.Institute;

public interface InstituteRepository extends JpaRepository<Institute, Integer> {

	
	
	List<Institute> findByName(String name);
	
	Institute findByUsername(String username);
}
