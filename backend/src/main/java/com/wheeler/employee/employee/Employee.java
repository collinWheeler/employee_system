package com.wheeler.employee.employee;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wheeler.employee.ability.Ability;

import lombok.Data;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(uniqueConstraints={
	    @UniqueConstraint(columnNames = {"name", "employee_id"})
	})
public class Employee {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	@Column(name="employee_id")
	private String employeeId;
	private String title;
	
	@ManyToMany(cascade={
		CascadeType.PERSIST,
		CascadeType.MERGE
	})
	@JoinTable(name="EMPLOYEE_ABILITY")
	private Set<Ability> abilities=new HashSet<>();
	
	@ManyToOne
	private Employee superior;
	
		
	public void addAbility(Ability ability) {
		abilities.add(ability);
	}
	
	public void removeAbility(Ability ability) {
		abilities.remove(ability);
	}
	
	public boolean hasAbility(Ability ability) {
		return abilities.contains(ability);
	}
	
}
