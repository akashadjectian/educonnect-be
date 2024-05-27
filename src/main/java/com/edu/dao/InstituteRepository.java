package com.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edu.entity.Institute;

public interface InstituteRepository extends JpaRepository<Institute, Integer> {

	
	
	@Query("SELECT i FROM Institute i WHERE i.name ILIKE %:name%")
    List<Institute> searchByName(@Param("name") String name);
	
	Institute findByUsername(String username);
}
