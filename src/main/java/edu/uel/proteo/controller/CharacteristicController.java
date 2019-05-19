package edu.uel.proteo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.uel.proteo.model.Characteristic;
import edu.uel.proteo.services.CharacteristicService;
import edu.uel.proteo.services.CharacteristicStateService;

@RestController
@RequestMapping("/characteristic")
public class CharacteristicController {

	@Autowired
	private CharacteristicService characteristicService;
	
	@Autowired
	private CharacteristicStateService css;
	
	@RequestMapping(value = "/create", method = RequestMethod.PUT)
	public Characteristic create(@RequestBody Characteristic character) {
		return characteristicService.create(character);
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public Characteristic update(@PathVariable Long id, @RequestBody Characteristic character) {
		return characteristicService.update(character);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		characteristicService.delete(id);
	}
	
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public Characteristic view(@PathVariable Long id) {
		return characteristicService.findById(id);
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Characteristic> list() {
		return characteristicService.findAll(0, 10);
	}
	
	@RequestMapping(value = "/add/{id}", method = RequestMethod.POST)
	public Characteristic view(@PathVariable Long id, @RequestParam Long stateId) {
		return characteristicService.add(characteristicService.findById(id), css.findById(stateId));
	}
}
