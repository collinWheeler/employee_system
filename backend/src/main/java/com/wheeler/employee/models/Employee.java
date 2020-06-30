package com.wheeler.employee.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.wheeler.employee.models.Ability;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
/*@Table(uniqueConstraints={
	    @UniqueConstraint(columnNames = {"name", "employee_id"})
	})*/
public class Employee {
	@Id
	@GeneratedValue
	private long id;
	@Length(max=100)
	private String name;
	@Column(name="employee_id",unique=true)
	@Length(max=20)
	private String employeeId;
	private String title;
	
	@ManyToMany
	@JoinTable(name="EMPLOYEE_ABILITY")
	private Set<Ability> abilities;
	
	@ManyToOne
	private Employee superior;
	
		
	public void setName(String name) {
		this.name = name;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAbilities(Set<Ability> abilities) {
		this.abilities = abilities;
	}

	public void setSuperior(Employee superior) {
		this.superior = superior;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public String getTitle() {
		return title;
	}

	@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
	@JsonIdentityReference(alwaysAsId = true)
	public Set<Ability> getAbilities() {
		return abilities;
	}

	public Employee getSuperior() {
		return superior;
	}

	public void addAbility(Ability ability) {
		abilities.add(ability);
	}
	
	/*@JsonSetter("")
	public void setAbilities(long[] abilityIds) {
		for(long id:abilityIds) {
			
		}
	}*/
	
	public void removeAbility(Ability ability) {
		abilities.remove(ability);
	}
	
	public boolean hasAbility(Ability ability) {
		return abilities.contains(ability);
	}
	
}