package com.wheeler.employee.ability;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.wheeler.employee.employee.Employee;

import lombok.Data;

@Data
@Entity
public class Ability {
	@Id
	@GeneratedValue
	private long id;
	
	@Column(unique=true)
	private String description;
	
	@ManyToMany(mappedBy = "abilities")
	private Set<Employee> employees;
	
	public Ability() {}
	
	public Ability(String description) {this.description=description;}
}
