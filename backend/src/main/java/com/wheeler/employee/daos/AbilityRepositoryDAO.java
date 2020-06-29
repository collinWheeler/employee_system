package com.wheeler.employee.daos;

import java.util.List;

import com.wheeler.employee.models.Ability;
import com.wheeler.employee.repositories.AbilityRepository;

public class AbilityRepositoryDAO implements AbilityDAO {

	private AbilityRepository repository;
	
	public AbilityRepositoryDAO(AbilityRepository repository) {
		this.repository=repository;
	}
	
	public Ability get(long id) {
		return repository.getOne(id);
	}
	
	public List<Ability> getAllFor(List<Long> ids){
		return repository.findAllById(ids);
	}

	public List<Ability> getAll() {
		return repository.findAll();
	}

	public Ability create(Ability ability) {
		return repository.save(ability);
	}

	public Ability update(Ability ability) {
		return null;
	}

	public void delete(Ability ability) {
		repository.delete(ability);
	}

	public boolean exists(Ability ability) {
		return repository.existsById(ability.getId());
	}

	public int count() {
		return (int)repository.count();
	}

}
