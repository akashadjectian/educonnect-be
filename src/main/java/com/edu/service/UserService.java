package com.edu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.UserRepository;
import com.edu.dto.LoginCredentials;
import com.edu.entity.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void save(User user) {
		this.userRepository.save(user);
	}
	
	
	public List<User> getAllUsers(){
		return this.userRepository.findAll();
	}
	
//	--------------login ------------------------------
	
	public boolean isExist(LoginCredentials loginCredentials) {		
		User user = this.userRepository.findByUsername(loginCredentials.getUsername());
		System.out.println("login---------------------------"+loginCredentials);
		System.out.println("existing user---------------------------"+user);
		

		if(user != null) {
			return true;
		}		
		return false;
		
	}
	
	public boolean checkCredential(LoginCredentials loginCredentials) {
		
		String username = loginCredentials.getUsername();
		String password = loginCredentials.getPassword();
		System.out.println("login---------------------------"+loginCredentials);
		
		User user = this.userRepository.findByUsername(loginCredentials.getUsername());	
		
		System.out.println(" this is the user "+user+"this sitheb "+password);
		if(user != null) {
			if(user.getPassword().equals(password)){
				System.out.println(" inside the matched pas-------------------------------------------");
				return true;
			}
		}
		
		
		return false;
	}


	public String getRoleByUsername(String username) {
		// TODO Auto-generated method stub		
		return this.userRepository.getRoleByUsername(username);
	}
	
	
}
