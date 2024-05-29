package com.edu.entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String age;
	private String mobile;
	private String email;
	private String experience;
	private List<String> subject;
	private String highestQualification;
	private String about;
	@ManyToOne()
	@JsonBackReference
	private Institute institute;

	
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", age=" + age + ", mobile=" + mobile + ", email=" + email
				+ ", experience=" + experience + ", subject=" + subject + ", highestQualification="
				+ highestQualification + ", about=" + about + ", institute=" + institute + "]";
	}

	public Teacher() {
		super();
	}
	

	public Teacher(Integer id, String name, String age, String mobile, String email, String experience,
			List<String> subject, String highestQualification, String about, Institute institute) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.mobile = mobile;
		this.email = email;
		this.experience = experience;
		this.subject = subject;
		this.highestQualification = highestQualification;
		this.about = about;
		this.institute = institute;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public List<String> getSubject() {
		return subject;
	}

	public void setSubject(List<String> subject) {
		this.subject = subject;
	}

	public String getHighestQualification() {
		return highestQualification;
	}

	public void setHighestQualification(String highestQualification) {
		this.highestQualification = highestQualification;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public Institute getInstitute() {
		return institute;
	}

	public void setInstitute(Institute institute) {
		this.institute = institute;
	}

}
