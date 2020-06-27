package com.wheeler.employee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wheeler.employee.ability.AbilityRepository;
import com.wheeler.employee.ability.AbilityDAOImpl;
import com.wheeler.employee.ability.AbilityDAO;
import com.wheeler.employee.employee.EmployeeRepository;
import com.wheeler.employee.employee.EmployeeDAOImpl;
import com.wheeler.employee.employee.EmployeeDAO;

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
