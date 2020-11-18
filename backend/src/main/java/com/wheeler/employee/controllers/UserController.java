package com.wheeler.employee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wheeler.employee.contracts.AppUserRegisterContract;
import com.wheeler.employee.contracts.EmployeeContract;
import com.wheeler.employee.exceptions.UserAlreadyExistsException;
import com.wheeler.employee.models.AppUser;
import com.wheeler.employee.models.Employee;
import com.wheeler.employee.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserController {
	public static final String BASE_URL = "/user";
	
	@Autowired
	private UserService userService;
	
	@PostMapping(BASE_URL)
	public @ResponseBody AppUser writeAppUser(@RequestBody AppUserRegisterContract contract) throws UserAlreadyExistsException {
		return userService.createUser(contract.email, contract.password, contract.username);
	}
	
}
