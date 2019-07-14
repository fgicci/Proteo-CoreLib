package edu.uel.proteo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uel.proteo.model.Athlete;
import edu.uel.proteo.services.AthleteService;

@RestController
@RequestMapping("/athlete")
public class AthleteController extends StdRecordController<Athlete, Long> {

	@Autowired
	public AthleteController(AthleteService athleteService) {
		super(athleteService);
	}
}
