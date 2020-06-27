package com.wheeler.employee.daos;

import java.util.List;

import com.wheeler.employee.models.Employee;
import com.wheeler.employee.repositories.EmployeeRepository;

public class EmployeeDAOImpl implements EmployeeDAO{

	private EmployeeRepository repository;
	
	public EmployeeDAOImpl(EmployeeRepository repository){
		this.repository=repository;
	}
	
	@Override
	public Employee create(Employee employee) {
		return repository.saveAndFlush(employee);
	}

	@Override
	public Employee get(Long id) {
		return repository.getOne(id);
	}

	@Override
	public List<Employee> getAll() {
		return repository.findAll();
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Employee update(Long id, Employee newEmployee) {
		Employee employee=repository.getOne(id);
		employee.setName(newEmployee.getName());
		employee.setEmployeeId(newEmployee.getEmployeeId());
		employee.setTitle(newEmployee.getTitle());
		employee.setAbilities(newEmployee.getAbilities());
		employee.setSuperior(newEmployee.getSuperior());
		return repository.save(employee);
	}
	
	@Override
	public int count() {
		return (int)repository.count();
	}
	
	@Override
	public boolean exists(Long id) {
		return repository.existsById(id);
	}
	
}
