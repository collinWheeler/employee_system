package com.wheeler.employee.employee;

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

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class EmployeeController {
	@Autowired
	private EmployeeDAO employeeDAO;
	
	private final String BASE_URL="/employee";
	
	@GetMapping(BASE_URL)
	public @ResponseBody List<Employee> getAll(){
		log.info("getAll called");
		return employeeDAO.getAll();
	}
	
	@GetMapping(BASE_URL+"/{id}")
	public @ResponseBody Employee getEmployee(@PathVariable long id) {
		log.info("getEmployee called "+id);
		return employeeDAO.get(id);
	}
	
	@PostMapping(BASE_URL)
	public @ResponseBody Employee createEmployee(@RequestBody Employee newEmployee) {
		log.info("createEmployee called");
		return employeeDAO.create(newEmployee);
	}
	
	@PutMapping(BASE_URL+"/{id}")
	public @ResponseBody Employee updateEmployee(@RequestBody Employee employee,@PathVariable long id) {
		return employeeDAO.update(id, employee);
	}
	
	@DeleteMapping(BASE_URL+"/{id}")
	public void deleteEmployee(@PathVariable long id) {
		employeeDAO.delete(id);
	}
}
