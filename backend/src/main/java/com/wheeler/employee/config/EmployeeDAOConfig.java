package com.wheeler.employee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wheeler.employee.ability.AbilityRepository;
import com.wheeler.employee.ability.AbilityRepositoryDAO;
import com.wheeler.employee.employee.EmployeeRepository;
import com.wheeler.employee.employee.EmployeeRepositoryDAO;

@Configuration
public class EmployeeDAOConfig {
	@Bean
	EmployeeRepositoryDAO employeeDAO(EmployeeRepository repository) {
		return new EmployeeRepositoryDAO(repository);
	}
	
	@Bean
	AbilityRepositoryDAO abilityDAO(AbilityRepository repository) {
		return new AbilityRepositoryDAO(repository);
	}
}
