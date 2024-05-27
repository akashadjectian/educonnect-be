package com.edu.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "institute_favourite")
public class InstituteFavourite {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	
	private Integer studentId;
	@OneToMany
	private List<Institute> institutes;
	@Override
	public String toString() {
		return "InstituteFavourite [id=" + id + ", studentId=" + studentId + ", institutes=" + institutes + "]";
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
	public List<Institute> getInstitutes() {
		return institutes;
	}
	public void setInstitutes(List<Institute> institutes) {
		this.institutes = institutes;
	}
	public InstituteFavourite() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InstituteFavourite(Integer id, Integer studentId, List<Institute> institutes) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.institutes = institutes;
	}
	
	
	
	
	
	
	
	
	
	
	
}

