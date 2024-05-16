package com.edu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.dto.LoginCredentials;
import com.edu.entity.User;
import com.edu.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class MainController {
	
	@Autowired
	private UserService userService;

	
	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody User user) {
		System.out.println(" insdie the use ----------------------"+user);
		this.userService.save(user);
		return  ResponseEntity.ok().body("success");
	}
	
	@GetMapping("/getUsers")
	public ResponseEntity<Object> getAllUsers() {
		 List<User> users =   this.userService.getAllUsers();
		return  ResponseEntity.ok().body(users);
	}
	
	
//	-------------------  login -----------------------------------------------
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody LoginCredentials loginCredentials){	
		Map<String ,String > map = new HashMap<>();	
	
		if(this.userService.isExist(loginCredentials)) {
			if(this.userService.checkCredential(loginCredentials)) {
				String role = this.userService.getRoleByUsername(loginCredentials.getUsername());
				map.put("role",role);
				map.put("response", "successful login");
				map.put("success","true");
				
				return ResponseEntity.ok().body(this.convertIntoJson(map));
			}
			map.put("response", "password is wrong ");
			map.put("success","false");
			return ResponseEntity.ok().body(map);
		}
		map.put("response", "user not found");
		map.put("success","false");
		return ResponseEntity.ok().body(map);
	}
	
	
	public String convertIntoJson(Map<String,String> map) {
		
		   ObjectMapper objectMapper = new ObjectMapper();
           try {
			String json = objectMapper.writeValueAsString(map);
			return json;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "not change into json";	
	}
	
	
	
}
