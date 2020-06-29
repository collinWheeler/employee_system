package com.wheeler.employee.daos;

import java.util.List;

import com.wheeler.employee.models.Employee;

public interface EmployeeDAO {
	public Employee create(Employee employee);
		
	public Employee get(Long id);
	
	public List<Employee> getAll();
	
	public void delete(Long id);
	
	public Employee update(Employee employee);
	
	public int count();
	
	public boolean exists(Long id);
}
