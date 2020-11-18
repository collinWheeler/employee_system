package com.wheeler.employee.daos;

import java.util.Optional;

import com.wheeler.employee.models.AppUser;
import com.wheeler.employee.repositories.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserRepositoryDAO implements UserDAO {

	private UserRepository repository;
	
	@Override
	public Optional<AppUser> getUserById(long id) {
		return repository.findById(id);
	}

	@Override
	public Optional<AppUser> getUserByLogin(String email, String password) {
		return repository.findUserByEmailAndPassword(email, password);
	}

	@Override
	public void saveUser(AppUser user) {
		repository.save(user);
	}
	
	@Override
	public Optional<AppUser> getUserByEmail(String email) {
		return repository.findByEmail(email);
	}

}
