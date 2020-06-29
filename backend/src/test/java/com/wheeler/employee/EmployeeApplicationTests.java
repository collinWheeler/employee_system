package com.wheeler.employee;

import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.wheeler.employee.daos.AbilityDAO;
import com.wheeler.employee.daos.EmployeeDAO;

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

}
