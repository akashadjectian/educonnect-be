package com.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.InstituteFavouriteRepository;
import com.edu.entity.Institute;

@Service
public class InstituteFavouriteService {

	@Autowired
	private InstituteFavouriteRepository instituteFavouriteRepository;
	
	
	public List<Institute> getAllInstitutes(Integer id){
		return this.instituteFavouriteRepository.findByStudentId(id);
	}
	
}
