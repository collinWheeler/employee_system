package com.wheeler.employee;

import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.wheeler.employee.ability.Ability;
import com.wheeler.employee.ability.AbilityDAO;
import com.wheeler.employee.employee.Employee;
import com.wheeler.employee.employee.EmployeeDAO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeApplicationTests {
	
	@Autowired
	EmployeeDAO employeeDAO;
	
	@Autowired
	AbilityDAO abilityDAO;

	@Test
	public void basicTest() {
		
	}
	/*@Test
	@Transactional
	@Rollback(true)
	public void employeeDaoTest() {
		Employee employee=new Employee();
		Employee newEmployee;
		employee.setName("Ray Arnold");
		employee.setTitle("Architect");
		employee.setEmployeeId("99-4321-9245");
		newEmployee=employeeDAO.create(employee);
		long id=newEmployee.getId();
		assertEquals(employee,newEmployee);
		
		Employee titleEmployee=employeeDAO.get(id);
		titleEmployee.setTitle("Chief Architect");
		newEmployee=employeeDAO.update(titleEmployee.getId(),titleEmployee);
		assertEquals(titleEmployee,newEmployee);
		
		employeeDAO.delete(id);
		assertEquals(false,employeeDAO.exists(id));
	}*/
	
	/*
	@Test
	@Transactional
	@Rollback(true)
	public void abilityDaoTest() {
		Ability ability1=new Ability("UNIX DEBUGGING");
		abilityDAO.create(ability1);
		assertEquals(true,abilityDAO.exists(ability1));
	}*/
	
	/*@Test
	public void employeeAbilityTest() {
		Employee employee=new Employee();
		employee.setName("Robert Muldoon");
		Ability ability1=new Ability("FORKLIFT CERTIFIED");
		Ability ability2=new Ability("CARNIVORE CERTIFIED");
		employee.addAbility(ability1);
		employee.addAbility(ability2);
		assertEquals(true,employee.hasAbility(ability1)&&employee.hasAbility(ability2));
	}*/

}
