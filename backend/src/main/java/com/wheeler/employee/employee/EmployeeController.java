package com.wheeler.employee.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class EmployeeController {
	@Autowired
	private EmployeeDAO employeeDAO;
	
	private final String BASE_URL="/employee";
	
	@GetMapping(BASE_URL)
	List<Employee> getAll(){
		log.info("getAll called");
		return employeeDAO.getAll();
	}
	
	@GetMapping(BASE_URL+"/{id}")
	Employee getEmployee(@PathVariable long id) {
		log.info("get/"+id+" called");
		return employeeDAO.get(id);
	}
	
	@PostMapping(BASE_URL)
	Employee createEmployee(@RequestBody Employee newEmployee) {
		log.info("createEmployee called");
		return employeeDAO.create(newEmployee);
	}
}
