package com.wheeler.employee.ability;

import java.util.List;

public interface AbilityDAO {
	public Ability get(long id);
	
	public List<Ability> getAll();
	
	public Ability create(Ability ability);
	
	public Ability update(Ability ability);
	
	public void delete(Ability ability);
	
	public boolean exists(Ability ability);
	
	public int count();
}
