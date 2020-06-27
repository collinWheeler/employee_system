package com.wheeler.employee.daos;

import java.util.List;

import com.wheeler.employee.models.Ability;
import com.wheeler.employee.repositories.AbilityRepository;

public class AbilityDAOImpl implements AbilityDAO {

	private AbilityRepository repository;
	
	public AbilityDAOImpl(AbilityRepository repository) {
		this.repository=repository;
	}
	
	@Override
	public Ability get(long id) {
		return repository.getOne(id);
	}

	@Override
	public List<Ability> getAll() {
		return repository.findAll();
	}

	@Override
	public Ability create(Ability ability) {
		return repository.save(ability);
	}

	@Override
	public Ability update(Ability ability) {
		return null;
	}

	@Override
	public void delete(Ability ability) {
		repository.delete(ability);
	}

	@Override
	public boolean exists(Ability ability) {
		return repository.existsById(ability.getId());
	}

	@Override
	public int count() {
		return (int)repository.count();
	}

}
