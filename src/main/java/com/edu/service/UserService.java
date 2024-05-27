package com.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.StudentRepository;
import com.edu.dao.UserRepository;
import com.edu.dto.LoginCredentials;
import com.edu.dto.UserDetailsDto;
import com.edu.entity.Student;
import com.edu.entity.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private StudentRepository studentRepository;
	
	public void save(User user) {
		user.setStatus(true);
		this.userRepository.save(user);
		if(user.getRole().equalsIgnoreCase("student")) {
			Student student = new Student();
			student.setFirstName(user.getUsername());
			student.setEmail(user.getEmail());
			student.setUsername(user.getUsername());
			this.studentRepository.save(student);
		}
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
	
	public UserDetailsDto getUserBYUsername(String username) {
		
		User user = this.userRepository.findByUsername(username);
		
		if(user != null) {
			UserDetailsDto userdto  = new UserDetailsDto();
			userdto.setId(user.getId());
			userdto.setUsername(user.getUsername());
			userdto.setEmail(user.getEmail());
			userdto.setRole(user.getRole());
			userdto.setStatus(user.getStatus());
			return userdto;
			
		}
		
		return null;
	}
	
}
