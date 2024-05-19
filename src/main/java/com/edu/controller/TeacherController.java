package com.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.entity.Teacher;
import com.edu.exception.CustomException;
import com.edu.exception.ResponseMessage;
import com.edu.service.TeacherService;

@RestController
@RequestMapping("/teacher")
@CrossOrigin("*")
public class TeacherController {

	
	@Autowired
	private TeacherService teacherService;
	
	//for save Teacher
		@PostMapping("/save")
	    public ResponseEntity<Object> addTeacher(@RequestBody Teacher teacher) {
	        try {
	            boolean saved = this.teacherService.saveTeacher(teacher);
	            if (saved) {
	                return ResponseEntity.ok(new ResponseMessage(teacher.getId() +" New teacher saved successfully"));
	            } else {
	                throw new CustomException("Failed to save teacher. Invalid data or duplicate entry.");
	            }
	        } 
	        catch (CustomException e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Error saving teacher: " + e.getMessage()));
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseMessage("Error saving teacher: " + e.getMessage()));
	        }
	    }

		@PostMapping("/update")
		public ResponseEntity<Object> updateTeacher(@RequestBody Teacher teacher) {
			
		    try {
		         this.teacherService.updateTeacher(teacher);
		        return ResponseEntity.ok().body(new ResponseMessage("Teacher updated successfully"));
		    } catch (CustomException e) {
		        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Error updating teacher: " + e.getMessage()));
		    } catch (Exception e) {
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseMessage("Error updating teacher: " + e.getMessage()));
		    }
		    
		}


		
		@GetMapping("/get")
		public ResponseEntity<List<Teacher>> getAllTeacher(){
			List<Teacher> teacherlist =  this.teacherService.getAllTeacher();
			System.out.println("wertyuio"+teacherlist);
			return ResponseEntity.ok().body(teacherlist);
		}
		
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<String> deleteTeacher(@PathVariable Integer id){
			if(id != null) {
				if(teacherService.deleteTeacher(id)) {
					return ResponseEntity.ok().body("teacher is deleted successfully ");
				}else {
					return ResponseEntity.ok().body("teacher is not exist ");
				}
			}
	    	return ResponseEntity.ok().body("deleted");
	    }
		
		
		@GetMapping("/get/{id}")
		public ResponseEntity<Object> getOneTeacher(@PathVariable Integer id){
			Teacher teacher = null;
			if(id != null) {
				teacher = this.teacherService.getOneTeacher(id);
				if(teacher != null) {
					return ResponseEntity.ok().body(teacher);
				}else {
					return ResponseEntity.ok().body("teacher is not exist of this id "+ id);
				}
			}
			return ResponseEntity.ok().body(" id is null ");
			
		}
}
