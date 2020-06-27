package com.wheeler.employee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wheeler.employee.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	
}
