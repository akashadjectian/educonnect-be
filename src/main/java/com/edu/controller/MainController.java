package com.edu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edu.dto.LoginCredentials;
import com.edu.dto.UserDetailsDto;
import com.edu.dto.Username;
import com.edu.entity.User;
import com.edu.exception.ResponseMessage;
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
	
	  @GetMapping("/verify-email")
	    public String verifyEmail(@RequestParam("token") String token) {
		  System.err.println("------------------------------------------------inside the verify --------------------------------------");
	        boolean isVerified = userService.verifyEmailToken(token);
	        if (isVerified) {
	            return "Email successfully verified!";
	        } else {
	            return "Invalid verification token.";
	        }
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
				if(this.userService.isVerified(loginCredentials)) {
					String role = this.userService.getRoleByUsername(loginCredentials.getUsername());
					map.put("role",role);
					map.put("response", "successful login");
					map.put("success","true");
					
					return ResponseEntity.ok().body(this.convertIntoJson(map));					
				}else {
					map.put("response", "email  is not verified");
					map.put("success","false");
					return ResponseEntity.ok().body(this.convertIntoJson(map));	
				}
		
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
	
	@GetMapping("/get-one/{username}")
	public  ResponseEntity<Object> getUserBYUsername(@PathVariable String username){
		System.err.println(" inside the controller of the usernma e "+username);
		if(username != null) {
			ResponseMessage responseMessage   = new ResponseMessage();
			
			UserDetailsDto user = this.userService.getUserBYUsername(username);
			if(user != null) {
				return ResponseEntity.ok().body(user);
				
			}else {
				 responseMessage.setresponseMessage("user is not found");
				return ResponseEntity.ok().body(responseMessage);			}
		}else {
			return ResponseEntity.ok().body("id is null");
		}
		
	}
	@PostMapping("/check-user")
	public ResponseEntity<Boolean> checkUserName(@RequestBody Username username){
		System.err.println("---------------  "+username);
		if(this.userService.checkUser(username.getUsername())) {
			return ResponseEntity.ok().body(true);
		}
		
	
		return ResponseEntity.ok().body(false);
	}
	
	
	
}
