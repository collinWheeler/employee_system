package com.wheeler.employee.daos;

import java.util.Optional;

import com.wheeler.employee.models.AppUser;

public interface UserDAO {
	public Optional<AppUser> getUserById(long id);
	
	public Optional<AppUser> getUserByLogin(String email, String password);
	
	public void saveUser(AppUser user);
	
	public Optional<AppUser> getUserByEmail(String email);
}
