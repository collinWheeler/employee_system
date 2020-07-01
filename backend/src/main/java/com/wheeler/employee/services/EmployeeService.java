package com.wheeler.employee.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wheeler.employee.contracts.EmployeeContract;
import com.wheeler.employee.daos.AbilityDAO;
import com.wheeler.employee.daos.EmployeeDAO;
import com.wheeler.employee.models.Ability;
import com.wheeler.employee.models.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployeeService {
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Autowired
	private AbilityDAO abilityDAO;
	
	public List<Employee> getAllEmployees(){
		return employeeDAO.getAll();
	}
	
	public Employee getEmployeeForId(long id) {
		Employee e = employeeDAO.get(id);
		return e;
	}
	
	public Employee writeEmployee(EmployeeContract contract) {
		Employee employee = mapEmployeeContract(contract);
		return employeeDAO.create(employee);
	}
	
	public Employee updateEmployee(EmployeeContract contract, long id) {
		Employee existingEmployee=getEmployeeForId(id);
		Employee newEmployee = mapEmployeeContract(contract);
		existingEmployee.setName(newEmployee.getName());
		existingEmployee.setEmployeeId(newEmployee.getEmployeeId());
		existingEmployee.setTitle(newEmployee.getTitle());
		existingEmployee.setAbilities(newEmployee.getAbilities());
		existingEmployee.setSuperior(newEmployee.getSuperior());
		return employeeDAO.update(existingEmployee);
	}
	
	public void deleteEmployee(long id) {
		employeeDAO.delete(id);
	}
	
	private Employee mapEmployeeContract(EmployeeContract contract) {
		Employee employee = new Employee();
		employee.setName(contract.name);
		employee.setEmployeeId(contract.employeeId);
		employee.setTitle(contract.title);
		if(contract.superiorId != null) {
			Employee superior = employeeDAO.get(contract.superiorId);
			employee.setSuperior(superior);
		}
		if(contract.abilityIds != null && !contract.abilityIds.isEmpty()) {
			List<Long> abilityIds = new ArrayList<>(contract.abilityIds);
			Set<Ability> abilities = new HashSet<Ability>(abilityDAO.getAllFor(abilityIds));
			employee.setAbilities(abilities);
		}
		return employee;
	}
}
