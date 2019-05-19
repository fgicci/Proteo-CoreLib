package edu.uel.proteo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.uel.proteo.model.CharacteristicState;
import edu.uel.proteo.services.CharacteristicStateService;
import edu.uel.proteo.services.CharacteristicStateTypeService;

@RestController
@RequestMapping("/states")
public class CharacteristicStateController {

	@Autowired
	private CharacteristicStateService characteristicStateService;
	
	@Autowired
	private CharacteristicStateTypeService characteristicStateTypeService;
	
	@RequestMapping(value = "/create", method = RequestMethod.PUT)
	public CharacteristicState create(@RequestBody CharacteristicState characteristicState) {
		return characteristicStateService.create(characteristicState);
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public CharacteristicState update(@PathVariable(value = "id") Long id, @RequestBody CharacteristicState characteristicState) {
		characteristicStateService.findById(id);
		return characteristicStateService.update(characteristicState);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		characteristicStateService.delete(id);
	}
	
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public CharacteristicState view(@PathVariable Long id) {
		return characteristicStateService.findById(id);
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<CharacteristicState> list() {
		return characteristicStateService.findAll(0, 10);
	}
	
	@RequestMapping(value = "type/names", method = RequestMethod.GET)
	public List<String> typeNames() {
		return characteristicStateTypeService.getAllNames();
	}
}
