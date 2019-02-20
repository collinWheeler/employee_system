package com.wheeler.employee;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wheeler.employee.ability.Ability;
import com.wheeler.employee.employee.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeApplicationTests {

	@Test
	public void employeeModelTest() {
		String name="Kevin McCallister";
		Employee employee=new Employee();
		employee.setName(name);
		assertEquals(name,employee.getName());
		
	}
	
	@Test
	public void employeeAbilityTest() {
		Employee employee=new Employee();
		employee.setName("Robert Muldoon");
		Ability ability1=new Ability("FORKLIFT CERTIFIED");
		Ability ability2=new Ability("CARNIVORE CERTIFIED");
		employee.addAbility(ability1);
		employee.addAbility(ability2);
		assertEquals(true,employee.hasAbility(ability1)&&employee.hasAbility(ability2));
	}

}
