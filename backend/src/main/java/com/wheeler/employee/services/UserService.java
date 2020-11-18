package com.wheeler.employee.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wheeler.employee.daos.UserDAO;
import com.wheeler.employee.exceptions.UserAlreadyExistsException;
import com.wheeler.employee.exceptions.UserNotFoundException;
import com.wheeler.employee.models.AppUser;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/*
	 * Get a user by an email/password combination
	 */
	public AppUser loginUser(String email, String password) throws UserNotFoundException {
		Optional<AppUser> user = userDAO.getUserByLogin(email, password);
		if(user.isPresent()) {
			return user.get();
		} else {
			throw new UserNotFoundException("User not found");
		}
	}
	
	/*
	 * Create a user
	 */
	
	public AppUser createUser(String email, String password, String userName) throws UserAlreadyExistsException{
		if(userName == null) {
			userName = email;
		}
		Optional<AppUser> existingUser = userDAO.getUserByEmail(email);
		if(existingUser.isPresent()) {
			throw new UserAlreadyExistsException("User already exists");
		}
		AppUser user = new AppUser();
		user.setEmail(email);
		user.setPassword(passwordEncoder.encode(password));
		user.setUserName(userName);
		userDAO.saveUser(user);
		return user;
	}
}
