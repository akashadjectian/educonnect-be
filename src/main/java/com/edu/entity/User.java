package com.edu.entity;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(unique = true)
	    private Integer id;
	 
	 	@Column(name = "user_name", unique = true)
	 	@NonNull
	    private String username;

	    @NonNull
	    @Column(name = "email", unique = true)
	    private String email;

	    @NonNull
	    @JsonIgnore
	    private String password;
	    
	    @NonNull
	    private String role;
	    
	    @NonNull
	    private Boolean status;
	 
	 
	 public User() {
	    }





	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", role="
				+ role + ", status=" + status + "]";
	}





	public User(Integer id, String username, String email, String password, String role, Boolean status) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
		this.status = status;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public Boolean getStatus() {
		return status;
	}


	public void setStatus(Boolean status) {
		this.status = status;
	}


	
	 
	 
	
}
