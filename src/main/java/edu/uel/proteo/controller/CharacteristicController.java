package edu.uel.proteo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.uel.proteo.model.Characteristic;
import edu.uel.proteo.services.CharacteristicService;
import edu.uel.proteo.services.CharacteristicStateService;

@RestController
@RequestMapping("/characteristic")
public class CharacteristicController extends StdRecordController<Characteristic, Long> {

	@Autowired
	private CharacteristicStateService css;
	
	private CharacteristicService characteristicService;
	
	@Autowired 
	public CharacteristicController(CharacteristicService characteristicService) {
		super(characteristicService);
		this.characteristicService = characteristicService;
	}
	
	@RequestMapping(value = "/add/{id}", method = RequestMethod.POST)
	public Characteristic view(@PathVariable Long id, @RequestParam Long stateId) {
		return characteristicService.add(characteristicService.findById(id), css.findById(stateId));
	}
}
