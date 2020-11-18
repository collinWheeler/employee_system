package com.wheeler.employee.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class AppUser {
	@Id
	@GeneratedValue
	@Getter @Setter
	private long id;
	
	@Getter @Setter
	private String userName;
	
	@Getter @Setter
	private String password;
	
	@Getter @Setter
	@Column(unique = true)
	private String email;
}
