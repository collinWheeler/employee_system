package com.wheeler.employee.employee;

import java.util.List;

public interface EmployeeDAO {
	public Employee create(Employee employee);
		
	public Employee get(Long id);
	
	public List<Employee> getAll();
	
	public void delete(Long id);
	
	public Employee update(Long id,Employee employee);
	
	public int count();
	
	public boolean exists(Long id);
}
