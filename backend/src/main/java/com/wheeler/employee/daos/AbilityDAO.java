package com.wheeler.employee.daos;

import java.util.List;

import com.wheeler.employee.models.Ability;

public interface AbilityDAO {
	public Ability get(long id);
	
	public List<Ability> getAllFor(List<Long> ids);
	
	public List<Ability> getAll();
	
	public Ability create(Ability ability);
	
	public Ability update(Ability ability);
	
	public void delete(Ability ability);
	
	public boolean exists(Ability ability);
	
	public int count();
}
