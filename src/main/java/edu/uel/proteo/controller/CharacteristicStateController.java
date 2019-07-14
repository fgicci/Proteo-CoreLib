package edu.uel.proteo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.uel.proteo.model.CharacteristicState;
import edu.uel.proteo.services.CharacteristicStateService;
import edu.uel.proteo.services.CharacteristicStateTypeService;

@RestController
@RequestMapping("/states")
public class CharacteristicStateController extends StdRecordController<CharacteristicState, Long> {

	@Autowired
	private CharacteristicStateTypeService characteristicStateTypeService;

	@Autowired
	public CharacteristicStateController(CharacteristicStateService characteristicStateService) {
		super(characteristicStateService);
	}

	@RequestMapping(value = "type/names", method = RequestMethod.GET)
	public List<String> typeNames() {
		return characteristicStateTypeService.getAllNames();
	}
}
