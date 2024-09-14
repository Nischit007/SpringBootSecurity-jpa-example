package com.example.mvc.Configure;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.mvc.Controller.MyUserDetails;
import com.example.mvc.Model.Users;
import com.example.mvc.Repository.UserRepository;

public class DefaultUserDetailsService implements UserDetailsService{
	
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Users> userInfo=userRepository.findByUsername(username);
		if(userInfo.isPresent()) {
		return new MyUserDetails(userInfo.get());
	}else {
		throw new UsernameNotFoundException("User not found with username: " + username);
	}
	}
}
