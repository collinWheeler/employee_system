package com.wheeler.employee.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.wheeler.employee.models.Employee;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Ability {
	@Id
	@GeneratedValue
	private long id;
	
	@Column(unique=true)
	private String description;
	
	@JsonBackReference
	@ManyToMany(mappedBy = "abilities")
	private Set<Employee> employees;
	
	public Ability() {}
	
	public Ability(String description) {this.description=description;}

	public long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	
}
