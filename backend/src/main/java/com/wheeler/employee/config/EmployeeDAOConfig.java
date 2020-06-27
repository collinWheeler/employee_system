package com.wheeler.employee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wheeler.employee.daos.AbilityDAO;
import com.wheeler.employee.daos.AbilityDAOImpl;
import com.wheeler.employee.daos.EmployeeDAO;
import com.wheeler.employee.daos.EmployeeDAOImpl;
import com.wheeler.employee.repositories.AbilityRepository;
import com.wheeler.employee.repositories.EmployeeRepository;

@Configuration
public class EmployeeDAOConfig {
	@Bean
	EmployeeDAO employeeDAO(EmployeeRepository repository) {
		return new EmployeeDAOImpl(repository);
	}
	
	@Bean
	AbilityDAO abilityDAO(AbilityRepository repository) {
		return new AbilityDAOImpl(repository);
	}
}
