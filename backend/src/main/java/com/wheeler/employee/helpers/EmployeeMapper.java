package com.wheeler.employee.helpers;

import com.wheeler.employee.contracts.EmployeeContract;
import com.wheeler.employee.models.Employee;

public interface EmployeeMapper {
	public Employee mapEmployeeContract(EmployeeContract contract);
	public EmployeeContract mapEmployee(Employee employee);
}
