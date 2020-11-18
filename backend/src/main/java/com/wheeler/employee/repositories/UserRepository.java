package com.wheeler.employee.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wheeler.employee.models.AppUser;

public interface UserRepository extends JpaRepository<AppUser,Long>{
	@Query(value="Select * from User where email=?1 and password=?2", nativeQuery=true)
	Optional<AppUser> findUserByEmailAndPassword(String email, String password);
	
	Optional<AppUser> findByEmail(String email);
}
