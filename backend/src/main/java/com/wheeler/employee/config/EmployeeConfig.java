package com.wheeler.employee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wheeler.employee.daos.AbilityDAO;
import com.wheeler.employee.daos.AbilityRepositoryDAO;
import com.wheeler.employee.daos.EmployeeDAO;
import com.wheeler.employee.daos.EmployeeRepositoryDAO;
import com.wheeler.employee.repositories.AbilityRepository;
import com.wheeler.employee.repositories.EmployeeRepository;
import com.wheeler.employee.services.EmployeeService;

@Configuration
public class EmployeeConfig {
	@Bean
	EmployeeDAO employeeDAO(EmployeeRepository repository) {
		return new EmployeeRepositoryDAO(repository);
	}
	
	@Bean
	AbilityDAO abilityDAO(AbilityRepository repository) {
		return new AbilityRepositoryDAO(repository);
	}
}
