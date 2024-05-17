package com.edu.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String courseId;
    private String courseName;
    private String description;
    private String instructor;
    private String schedule;
    private String prerequisites;
    @ManyToOne(cascade = CascadeType.ALL)
    private Institute institute;
    private int enrollmentCapacity;
    private boolean status;
	@Override
	public String toString() {
		return "Course [id=" + id + ", courseId=" + courseId + ", courseName=" + courseName + ", description="
				+ description + ", instructor=" + instructor + ", schedule=" + schedule + ", prerequisites="
				+ prerequisites + ", institute=" + institute + ", enrollmentCapacity=" + enrollmentCapacity
				+ ", status=" + status + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public String getPrerequisites() {
		return prerequisites;
	}
	public void setPrerequisites(String prerequisites) {
		this.prerequisites = prerequisites;
	}
	public Institute getInstitute() {
		return institute;
	}
	public void setInstitute(Institute institute) {
		this.institute = institute;
	}
	public int getEnrollmentCapacity() {
		return enrollmentCapacity;
	}
	public void setEnrollmentCapacity(int enrollmentCapacity) {
		this.enrollmentCapacity = enrollmentCapacity;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(Integer id, String courseId, String courseName, String description, String instructor,
			String schedule, String prerequisites, Institute institute, int enrollmentCapacity, boolean status) {
		super();
		this.id = id;
		this.courseId = courseId;
		this.courseName = courseName;
		this.description = description;
		this.instructor = instructor;
		this.schedule = schedule;
		this.prerequisites = prerequisites;
		this.institute = institute;
		this.enrollmentCapacity = enrollmentCapacity;
		this.status = status;
	}

    
   
    
}
