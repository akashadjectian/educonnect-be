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
import org.springframework.web.bind.annotation.RestController;

import com.edu.entity.Course;
import com.edu.exception.CustomException;
import com.edu.exception.ResponseMessage;
import com.edu.service.CourseService;

@RestController
public class CourseController {

	
	@Autowired
	private CourseService courseService;
	
	//for save Course
		@PostMapping("/add")
	    public ResponseEntity<Object> addCourse(@ModelAttribute Course course) {
	        try {
	            boolean saved = this.courseService.saveCourse(course);
	            if (saved) {
	                return ResponseEntity.ok(new ResponseMessage(course.getId() +" New course saved successfully"));
	            } else {
	                throw new CustomException("Failed to save course. Invalid data or duplicate entry.");
	            }
	        } 
	        catch (CustomException e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Error saving course: " + e.getMessage()));
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseMessage("Error saving course: " + e.getMessage()));
	        }
	    }

		@PostMapping("/update")
		public ResponseEntity<Object> updateCourse(@ModelAttribute Course course) {
			
		    try {
		         this.courseService.updateCourse(course);
		        return ResponseEntity.ok().body(new ResponseMessage("Course updated successfully"));
		    } catch (CustomException e) {
		        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Error updating course: " + e.getMessage()));
		    } catch (Exception e) {
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseMessage("Error updating course: " + e.getMessage()));
		    }
		    
		}


		
		@GetMapping("/get")
		public ResponseEntity<List<Course>> getAllCourse(){
			List<Course> Courselist = (List<Course>) this.courseService.getAllCourse();
			return ResponseEntity.ok().body(Courselist);
		}
		
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<String> deleteCourse(@PathVariable Integer id){
			if(id != null) {
				if(courseService.deleteCourse(id)) {
					return ResponseEntity.ok().body("course is deleted successfully ");
				}else {
					return ResponseEntity.ok().body("course is not exist ");
				}
			}
	    	return ResponseEntity.ok().body("deleted");
	    }
		
		
		@GetMapping("/get/{id}")
		public ResponseEntity<Object> getOneCourse(@PathVariable Integer id){
			Course course = null;
			if(id != null) {
				course = this.courseService.getOneCourse(id);
				if(course != null) {
					return ResponseEntity.ok().body(course);
				}else {
					return ResponseEntity.ok().body("course is not exist of this id "+ id);
				}
			}
			return ResponseEntity.ok().body(" id is null ");
			
		}
	
}
