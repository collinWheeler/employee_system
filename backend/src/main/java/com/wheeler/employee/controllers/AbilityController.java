package com.wheeler.employee.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wheeler.employee.contracts.AbilityContract;
import com.wheeler.employee.models.Ability;
import com.wheeler.employee.services.AbilityService;

@RestController
public class AbilityController {
	
	@Autowired
	private AbilityService service;

	private final String BASE_URL="/ability";
	
	@GetMapping(BASE_URL)
	public @ResponseBody List<Ability> getAllAbilities(){
		return service.getAllAbilities();
	}
	
	@GetMapping(BASE_URL + "/{id}")
	public @ResponseBody Ability getAbility(@PathVariable long id) {
		return service.getAbilityForId(id);
	}
	
	@PostMapping(BASE_URL)
	public @ResponseBody Ability writeAbility(@RequestBody AbilityContract contract) {
		return service.createAbility(contract);
	}
	
	@PutMapping(BASE_URL + "/{id}")
	public @ResponseBody Ability updateAbility(@RequestBody AbilityContract contract, @PathVariable long id) {
		return service.updateAbility(contract, id);
	}
	
	@DeleteMapping(BASE_URL + "/{id}")
	public void deleteAbility(@PathVariable long id) {
		service.deleteAbility(id);
	}
}
