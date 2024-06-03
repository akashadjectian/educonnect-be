package com.edu.dto;

public class Username {
	
	private String username;

	public Username() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Username(String username) {
		super();
		this.username = username;
	}

	@Override
	public String toString() {
		return "Username [username=" + username + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
