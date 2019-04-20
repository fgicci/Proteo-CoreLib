package edu.uel.proteo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.uel.proteo.model.Character;
import edu.uel.proteo.services.CharacterService;

@RestController
@RequestMapping("/character")
public class CharacterController {

	@Autowired
	private CharacterService characterService;
	
	@RequestMapping(value = "/create", method = RequestMethod.PUT)
	public Character create(Character character) {
		return characterService.save(character);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Character update(Character character) {
		return characterService.update(character);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		characterService.delete(id);
	}
	
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public Character view(@PathVariable Long id) {
		return characterService.findById(id);
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Character> list() {
		return characterService.findAll();
	}
}
