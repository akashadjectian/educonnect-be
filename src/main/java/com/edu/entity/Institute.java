package com.edu.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Institute {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private String directorName;
	
	private String officialMobile;
	
	private String watsappNumber;
	
	private String email1;
	
	private String email2;
	
	private String establishedDate;
	
	private String facilities;
	
	private String description;
	
	@OneToMany
	private List<Course> courses;

	@OneToMany
	private List<Student> students;
	
	@OneToMany
	private List<Teacher> teachers;
	
	@OneToOne
	private Address address;
	
	@OneToMany
	private List<SocialMediaLink> socialmediaLinks;

	private Boolean status;

	@Override
	public String toString() {
		return "Institute [id=" + id + ", name=" + name + ", directorName=" + directorName + ", officialMobile="
				+ officialMobile + ", watsappNumber=" + watsappNumber + ", email1=" + email1 + ", email2=" + email2
				+ ", establishedDate=" + establishedDate + ", facilities=" + facilities + ", description=" + description
				+ ", courses=" + courses + ", students=" + students + ", teachers=" + teachers + ", address=" + address
				+ ", socialmediaLinks=" + socialmediaLinks + ", status=" + status + "]";
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

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public String getOfficialMobile() {
		return officialMobile;
	}

	public void setOfficialMobile(String officialMobile) {
		this.officialMobile = officialMobile;
	}

	public String getWatsappNumber() {
		return watsappNumber;
	}

	public void setWatsappNumber(String watsappNumber) {
		this.watsappNumber = watsappNumber;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getEstablishedDate() {
		return establishedDate;
	}

	public void setEstablishedDate(String establishedDate) {
		this.establishedDate = establishedDate;
	}

	public String getFacilities() {
		return facilities;
	}

	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<SocialMediaLink> getSocialmediaLinks() {
		return socialmediaLinks;
	}

	public void setSocialmediaLinks(List<SocialMediaLink> socialmediaLinks) {
		this.socialmediaLinks = socialmediaLinks;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Institute(Integer id, String name, String directorName, String officialMobile, String watsappNumber,
			String email1, String email2, String establishedDate, String facilities, String description,
			List<Course> courses, List<Student> students, List<Teacher> teachers, Address address,
			List<SocialMediaLink> socialmediaLinks, Boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.directorName = directorName;
		this.officialMobile = officialMobile;
		this.watsappNumber = watsappNumber;
		this.email1 = email1;
		this.email2 = email2;
		this.establishedDate = establishedDate;
		this.facilities = facilities;
		this.description = description;
		this.courses = courses;
		this.students = students;
		this.teachers = teachers;
		this.address = address;
		this.socialmediaLinks = socialmediaLinks;
		this.status = status;
	}

	public Institute() {
		super();
	}
	
	
	

	
	
	
	
	
}
