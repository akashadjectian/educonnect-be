package com.edu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "course_favourite")
public class CourseFavourite {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	
	private Integer studentId;
	
	@ManyToOne
	private Course course;
	@Override
	public String toString() {
		return "CourseFavourite [id=" + id + ", studentId=" + studentId + ", course=" + course + "]";
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
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course= course;
	}
	public CourseFavourite(Integer id, Integer studentId, Course course) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.course = course;
	}
	public CourseFavourite() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
	
	

	
	
	
}
