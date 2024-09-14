package com.example.mvc.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mvc.Model.Users;
import com.example.mvc.Repository.UserRepository;

@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/")
	public String homepage() {
		return ("<h1>Welcome to home page</h1>");
	}
	
	
	@GetMapping("/user")
	public String userpage() {
		return ("<h1>Welcome to user page</h1>");
	}
	
	
	@GetMapping("/admin")
	public String adminpage() {
		return ("<h1>Welcome to admin page</h1>");
	}
	
	@GetMapping("/check")
	public List<Users> getAllUser(){
		return userRepository.findAll();
	}
}
