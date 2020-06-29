package com.wheeler.employee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wheeler.employee.contracts.AbilityContract;
import com.wheeler.employee.daos.AbilityDAO;
import com.wheeler.employee.models.Ability;

public class AbilityService {

	@Autowired
	private AbilityDAO abilityDAO;
	
	public Ability getAbilityForId(long id) {
		return abilityDAO.get(id);
	}
	
	public List<Ability> getAllAbilities(){
		return abilityDAO.getAll();
	}
	
	public Ability writeAbility(AbilityContract contract) {
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
		Ability ability = abilityDAO.get(id);
		abilityDAO.delete(ability);
	}
	
	private Ability mapAbilityContract(AbilityContract contract) {
		Ability ability = new Ability();
		ability.setDescription(contract.description);
		return ability;
	}
	
}
