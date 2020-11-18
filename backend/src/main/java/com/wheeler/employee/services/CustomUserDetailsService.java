package com.wheeler.employee.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wheeler.employee.daos.UserDAO;
import com.wheeler.employee.models.AppUser;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserDAO userDAO;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<AppUser> user = userDAO.getUserByEmail(email);
		if(user.isPresent()) {
			return mapUser(user.get());
		}else {
			throw new UsernameNotFoundException("Username not found");
		}
	}
	
	private UserDetails mapUser(AppUser appUser) {
		return User.withUsername(appUser.getEmail()).password(appUser.getPassword()).authorities("USER").build();
	}

}
