package com.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.InstituteFavouriteRepository;
import com.edu.entity.CourseFavourite;
import com.edu.entity.InstituteFavourite;

@Service
public class InstituteFavouriteService {

	@Autowired
	private InstituteFavouriteRepository instituteFavouriteRepository;

	public List<InstituteFavourite> getAllInstitutes(Integer id) {
		return this.instituteFavouriteRepository.findByStudentId(id);
	}

	// for add institute
	public boolean add(InstituteFavourite instituteFavourite) {
		if (instituteFavourite != null) {
			instituteFavouriteRepository.save(instituteFavourite);
			return true;
		}
		return false;
	}

	// for delete
	public boolean delete(Integer id) {
		if (id != null) {
			this.instituteFavouriteRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
