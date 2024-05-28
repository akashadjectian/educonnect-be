package com.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.entity.Course;
import com.edu.entity.Institute;
import com.edu.entity.Student;
import com.edu.exception.CustomException;
import com.edu.exception.ResponseMessage;
import com.edu.service.CourseFavouriteService;
import com.edu.service.InstituteFavouriteService;
import com.edu.service.StudentService;

@Controller
@RequestMapping("/student")
@CrossOrigin("*")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private CourseFavouriteService courseFavouriteService;
	@Autowired
	private InstituteFavouriteService instituteFavouriteService;

	// for save Student
	@PostMapping("/add")
	public ResponseEntity<Object> addStudent(@ModelAttribute Student student) {
		try {
			boolean saved = this.studentService.saveStudent(student);
			if (saved) {
				return ResponseEntity.ok(new ResponseMessage(student.getId() + " New student saved successfully"));
			} else {
				throw new CustomException("Failed to save student. Invalid data or duplicate entry.");
			}
		} catch (CustomException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ResponseMessage("Error saving student: " + e.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ResponseMessage("Error saving student: " + e.getMessage()));
		}
	}

	@PostMapping("/update")
	public ResponseEntity<Object> updateStudent(@ModelAttribute Student student) {

		try {
			this.studentService.updateStudent(student);
			return ResponseEntity.ok().body(new ResponseMessage("Student updated successfully"));
		} catch (CustomException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ResponseMessage("Error updating student: " + e.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ResponseMessage("Error updating student: " + e.getMessage()));
		}

	}

	@GetMapping("/get")
	public ResponseEntity<List<Student>> getAllStudent() {
		List<Student> Studentlist = (List<Student>) this.studentService.getAllStudent();
		return ResponseEntity.ok().body(Studentlist);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {
		if (id != null) {
			if (studentService.deleteStudent(id)) {
				return ResponseEntity.ok().body("student is deleted successfully ");
			} else {
				return ResponseEntity.ok().body("student is not exist ");
			}
		}
		return ResponseEntity.ok().body("deleted");
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Object> getOneStudent(@PathVariable Integer id) {
		Student student = null;
		if (id != null) {
			student = this.studentService.getOneStudent(id);
			if (student != null) {
				return ResponseEntity.ok().body(student);
			} else {
				return ResponseEntity.ok().body("student is not exist of this id " + id);
			}
		}
		return ResponseEntity.ok().body(" id is null ");

	}

	@GetMapping("/getbyusername")
	public ResponseEntity<Student> getByUserName(@RequestParam String username) {
		Student student = this.studentService.getByUserName(username);
		return ResponseEntity.ok().body(student);
	}

	@GetMapping("/get-favourite-courses/{id}")
	public ResponseEntity<List<Course>> getFavouriteCourses(@PathVariable Integer id) {
		if (id != null) {
			List<Course> courselist = this.courseFavouriteService.getAllCourses(id);
			return ResponseEntity.ok().body(courselist);
		}
		return ResponseEntity.ok().body(null);

	}

	@GetMapping("/get-favourite-institutes/{id}")
	public ResponseEntity<List<Institute>> getFavouriteInstitutes(@PathVariable Integer id) {
		if (id != null) {
			List<Institute> institutelist = this.instituteFavouriteService.getAllInstitutes(id);
			return ResponseEntity.ok().body(institutelist);
		}
		return ResponseEntity.ok().body(null);

	}

}
