package com.wheeler.employee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wheeler.employee.contracts.AbilityContract;
import com.wheeler.employee.daos.AbilityDAO;
import com.wheeler.employee.models.Ability;

@Service
public class AbilityService {

	@Autowired
	private AbilityDAO abilityDAO;
	
	public Ability getAbilityForId(long id) {
		return abilityDAO.get(id);
	}
	
	public List<Ability> getAllAbilities(){
		return abilityDAO.getAll();
	}
	
	public Ability createAbility(AbilityContract contract) {
		Ability ability = mapAbilityContract(contract);
		return abilityDAO.create(ability);
	}
	
	public Ability updateAbility(AbilityContract contract, long id) {
		Ability ability = abilityDAO.get(id);
		Ability newAbility = mapAbilityContract(contract);
		ability.setDescription(newAbility.getDescription());
		return abilityDAO.update(ability);
	}
	
	public void deleteAbility(long id) {
		abilityDAO.delete(id);
	}
	
	private Ability mapAbilityContract(AbilityContract contract) {
		return new Ability(contract.description);
	}
	
}
