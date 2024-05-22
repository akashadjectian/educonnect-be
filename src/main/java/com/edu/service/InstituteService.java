package com.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.InstituteRepository;
import com.edu.entity.Institute;

@Service
public class InstituteService {

@Autowired
private InstituteRepository instituteRepository;


// for saving the Institute
public boolean saveInstitute(Institute institute) {	
	if(institute != null) {
		instituteRepository.save(institute);
		return true;
	}
	return false;
}

//for getting a single institute
public Institute getOneInstitute(Integer id) {
		Institute institute = instituteRepository.findById(id).get();
		if(institute!=null) {
			return institute;
		}
		return null;
}

//for getting all institutelist 
public List<Institute> getAllInstitute(){		
	List<Institute> institutelist = (List<Institute>)instituteRepository.findAll(); 
	return institutelist;
}

//for delete the institute
public boolean deleteInstitute(Integer id) {
	if(id!=null) {
		this.instituteRepository.deleteById(id);
		return true;
	}
	return false;
}

//for update the institute
public Boolean updateInstitute(Institute institute) {
	if(institute != null) {
		instituteRepository.save(institute);
		return true;
	}
	return false;
}

public List<Institute> getSearchInstitute(String searchvalue){		
	List<Institute> institutelist = (List<Institute>)instituteRepository.findByName(searchvalue); 
	return institutelist;
}


public Institute getByUserName(String username){		
	Institute institute = instituteRepository.findByUsername(username); 
	return institute;
}




}
