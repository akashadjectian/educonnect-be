package com.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.entity.Institute;
import com.edu.entity.InstituteFavourite;

public interface InstituteFavouriteRepository extends JpaRepository<InstituteFavourite, Integer> {

	List<InstituteFavourite> findByStudentId(Integer id);
	
}
