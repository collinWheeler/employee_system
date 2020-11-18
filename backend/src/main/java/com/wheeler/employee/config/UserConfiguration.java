package com.wheeler.employee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wheeler.employee.daos.UserDAO;
import com.wheeler.employee.daos.UserRepositoryDAO;
import com.wheeler.employee.repositories.UserRepository;

@Configuration
public class UserConfiguration {
	
	@Bean
	UserDAO userDAO(UserRepository userRepository) {
		return new UserRepositoryDAO(userRepository);
	}
}
