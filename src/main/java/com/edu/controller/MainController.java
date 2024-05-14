package com.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.entity.User;
import com.edu.service.UserService;

@RestController
public class MainController {
	
	@Autowired
	private UserService userService;

	
	@PostMapping("/saveUser")
	public ResponseEntity<String> saveUser(User user) {
		this.userService.save(user);
		return  ResponseEntity.ok().body("success");
	}
	
	
	
}
