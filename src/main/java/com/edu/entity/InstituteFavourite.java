package com.edu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "institute_favourite")
public class InstituteFavourite {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	
	private Integer studentId;
	 @ManyToOne
	private Institute institute;
	@Override
	public String toString() {
		return "InstituteFavourite [id=" + id + ", studentId=" + studentId + ", institute=" + institute + "]";
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
	public Institute getInstitute() {
		return institute;
	}
	public void setInstitute(Institute institute) {
		this.institute = institute;
	}
	public InstituteFavourite() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InstituteFavourite(Integer id, Integer studentId, Institute institute) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.institute = institute;
	}
	
	 
	
	
	
	
	
	
	
}

