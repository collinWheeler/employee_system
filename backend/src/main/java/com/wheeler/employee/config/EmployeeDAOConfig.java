package com.wheeler.employee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wheeler.employee.employee.EmployeeRepository;
import com.wheeler.employee.employee.EmployeeRepositoryDAO;

@Configuration
public class EmployeeDAOConfig {
	@Bean
	EmployeeRepositoryDAO dao(EmployeeRepository repository) {
		return new EmployeeRepositoryDAO(repository);
	}
}
