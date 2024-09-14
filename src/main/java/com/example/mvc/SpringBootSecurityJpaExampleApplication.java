package com.example.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.mvc.Repository.UserRepository;

@SpringBootApplication
public class SpringBootSecurityJpaExampleApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringBootSecurityJpaExampleApplication.class, args);
		UserRepository userRepository=context.getBean(UserRepository.class);
		userRepository.findById(1);
		System.out.println(userRepository.findById(1));
		
	}

}
