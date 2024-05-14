package com.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.edu.entity.Institute;
import com.edu.exception.CustomException;
import com.edu.exception.ResponseMessage;
import com.edu.service.InstituteService;

@RestController
@RequestMapping("/institute")
public class InstituteController {
	
	@Autowired
	InstituteService instituteService;
	
	//for save Institute
	@PostMapping("/add")
    public ResponseEntity<Object> addInstitute(@ModelAttribute Institute institute) {
        try {
            boolean saved = this.instituteService.saveInstitute(institute);
            if (saved) {
                return ResponseEntity.ok(new ResponseMessage(institute.getId() +" New institute saved successfully"));
            } else {
                throw new CustomException("Failed to save institute. Invalid data or duplicate entry.");
            }
        } 
        catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Error saving institute: " + e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseMessage("Error saving institute: " + e.getMessage()));
        }
    }

	@PostMapping("/update")
	public ResponseEntity<Object> updateInstitute(@ModelAttribute Institute institute) {
		
	    try {
	         this.instituteService.updateInstitute(institute);
	        return ResponseEntity.ok().body(new ResponseMessage("Institute updated successfully"));
	    } catch (CustomException e) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Error updating institute: " + e.getMessage()));
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseMessage("Error updating institute: " + e.getMessage()));
	    }
	    
	}


	
	@GetMapping("/get")
	public ResponseEntity<List<Institute>> getAllInstitute(){
		List<Institute> Institutelist = (List<Institute>) this.instituteService.getAllInstitute();
		return ResponseEntity.ok().body(Institutelist);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteInstitute(@PathVariable Integer id){
		if(id != null) {
			if(instituteService.deleteInstitute(id)) {
				return ResponseEntity.ok().body("institute is deleted successfully ");
			}else {
				return ResponseEntity.ok().body("institute is not exist ");
			}
		}
    	return ResponseEntity.ok().body("deleted");
    }
	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Object> getOneInstitute(@PathVariable Integer id){
		Institute institute = null;
		if(id != null) {
			institute = this.instituteService.getOneInstitute(id);
			if(institute != null) {
				return ResponseEntity.ok().body(institute);
			}else {
				return ResponseEntity.ok().body("institute is not exist of this id "+ id);
			}
		}
		return ResponseEntity.ok().body(" id is null ");
		
	}
	

}
