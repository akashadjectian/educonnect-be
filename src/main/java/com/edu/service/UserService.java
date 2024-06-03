package com.edu.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.common.EmailService;
import com.edu.dao.StudentRepository;
import com.edu.dao.UserRepository;
import com.edu.dto.LoginCredentials;
import com.edu.dto.UserDetailsDto;
import com.edu.dto.Username;
import com.edu.entity.Address;
import com.edu.entity.Student;
import com.edu.entity.User;

import jakarta.mail.MessagingException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private StudentRepository studentRepository;
	@Autowired
	private EmailService emailService;
	
	public void save(User user) {
		user.setStatus(true);
		user.setVarified(false);
		String token = UUID.randomUUID().toString();
		user.settoken(token);
	    try {
			emailService.sendVerificationEmail(user.getEmail(), token);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		this.userRepository.save(user);
		if(user.getRole().equalsIgnoreCase("student")) {
			Student student = new Student();
			student.setFirstName(user.getUsername());
			student.setEmail(user.getEmail());
			student.setUsername(user.getUsername());
			student.setAddress(new Address());
			this.studentRepository.save(student);
		}
	}
	
	
	public boolean verifyEmailToken(String token) {		
		User user  = this.userRepository.findByToken(token);
		System.err.println("inside -----------------------------------------service     1---------------------");

		if(user != null) {
			user.setVarified(true);
			this.userRepository.save(user);
			System.err.println("inside -----------------------------------------service---------------------");
			return true;
		}
		return false;
		
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


	public boolean isVerified(LoginCredentials loginCredentials) {
		String username = loginCredentials.getUsername();
		User user = this.userRepository.findByUsername(loginCredentials.getUsername());			
		System.out.println(" this is the user "+user+"this sitheb ");
		if(user.isVarified()) {
			return true;
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
	
	public boolean checkUser(String username) {
		
		if(this.userRepository.existsByUsername(username)) {
			return true;
		}
		return false;
	}
	
	
	
	
}
