package com.edu.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "course_favourite")
public class CourseFavourite {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	
	private Integer studentId;
	@OneToMany
	private List<Course> courses;
	
	
	
	
	
	public CourseFavourite(Integer id, Integer studentId, List<Course> courses) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.courses = courses;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	
	public CourseFavourite() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	@Override
	public String toString() {
		return "CourseFavourite [id=" + id + ", studentId=" + studentId + ", courses=" + courses + "]";
	}
	
	
	
	
	

	
	
	
}
