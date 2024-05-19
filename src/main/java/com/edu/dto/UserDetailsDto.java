package com.edu.dto;

public class UserDetailsDto {
	
	private Integer id ;
	private String username;
	private String email;
	private String role;
	private boolean status ;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public UserDetailsDto(Integer id, String username, String email, String role, boolean status) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.role = role;
		this.status = status;
	}
	public UserDetailsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserDetailsDto [id=" + id + ", username=" + username + ", email=" + email + ", role=" + role
				+ ", status=" + status + "]";
	}
	
	
	

}
