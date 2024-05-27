package com.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edu.entity.Institute;

public interface InstituteRepository extends JpaRepository<Institute, Integer> {

	
	
	@Query("SELECT DISTINCT i FROM Institute i " +
		       "JOIN i.address a " +
		       "WHERE a.city ILIKE CONCAT('%', :query, '%')")
	List<Institute> searchByCity(@Param("query") String query);
	
	Institute findByUsername(String username);
}
