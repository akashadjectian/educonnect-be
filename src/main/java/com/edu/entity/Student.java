package com.edu.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Student {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	private String firstName;
	private String lastName;
	private String age;
	private String email;
	private String mobile;
	private String studyClass;
	private String schoolName;
	private String username;

	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	private String profilePhoto;

	

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStudyClass() {
		return studyClass;
	}

	public void setStudyClass(String studyClass) {
		this.studyClass = studyClass;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	public Student(String firstName) {
		super();
		this.firstName = firstName;
	}
	
	


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", email="
				+ email + ", mobile=" + mobile + ", studyClass=" + studyClass + ", schoolName=" + schoolName
				+ ", username=" + username + ", address=" + address + ", profilePhoto=" + profilePhoto + "]";
	}


	public Student(Integer id, String firstName, String lastName, String age, String email, String mobile,
			String studyClass, String schoolName, String username, Address address, String profilePhoto) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
		this.mobile = mobile;
		this.studyClass = studyClass;
		this.schoolName = schoolName;
		this.username = username;
		this.address = address;
		this.profilePhoto = profilePhoto;
	}
	
	
	
	
	
	
	

	
	
	
}
