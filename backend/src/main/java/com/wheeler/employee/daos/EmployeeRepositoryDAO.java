package com.wheeler.employee.daos;

import java.util.List;

import com.wheeler.employee.models.Employee;
import com.wheeler.employee.repositories.EmployeeRepository;

public class EmployeeRepositoryDAO implements EmployeeDAO{

	private EmployeeRepository repository;
	
	public EmployeeRepositoryDAO(EmployeeRepository repository){
		this.repository=repository;
	}
	
	public Employee create(Employee employee) {
		return repository.saveAndFlush(employee);
	}

	public Employee get(Long id) {
		return repository.getOne(id);
	}

	public List<Employee> getAll() {
		return repository.findAll();
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Employee update(Employee employee) {
		return repository.save(employee);
	}
	
	public int count() {
		return (int)repository.count();
	}
	
	public boolean exists(Long id) {
		return repository.existsById(id);
	}
	
}
