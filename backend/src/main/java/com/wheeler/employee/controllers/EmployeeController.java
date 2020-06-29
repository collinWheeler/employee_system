package com.wheeler.employee.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wheeler.employee.contracts.EmployeeContract;
import com.wheeler.employee.models.Employee;
import com.wheeler.employee.services.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class EmployeeController {
	
	private final String BASE_URL="/employee";
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping(BASE_URL)
	public @ResponseBody List<Employee> getAllEmployees(){
		log.info("getAll called");
		return service.getAllEmployees();
	}
	
	@GetMapping(BASE_URL+"/{id}")
	public @ResponseBody Employee getEmployee(@PathVariable long id) {
		log.info("getEmployee called "+id);
		return service.getEmployeeForId(id);
	}
	
	@PostMapping(BASE_URL)
	public @ResponseBody Employee writeEmployee(@RequestBody EmployeeContract newEmployee) {
		log.info("createEmployee called");
		return service.writeEmployee(newEmployee);
	}
	
	@PutMapping(BASE_URL+"/{id}")
	public @ResponseBody Employee updateEmployee(@RequestBody EmployeeContract employee,@PathVariable long id) {
		return service.updateEmployee(employee, id);
	}
	
	@DeleteMapping(BASE_URL+"/{id}")
	public void deleteEmployee(@PathVariable long id) {
		service.deleteEmployee(id);
	}
}
