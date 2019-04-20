package edu.uel.proteo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.uel.proteo.model.Athlete;
import edu.uel.proteo.services.AthleteService;

@RestController
@RequestMapping("/athlete")
public class AthleteController {

	@Autowired
	private AthleteService athleteService;
	
	@RequestMapping(value = "/create", method = RequestMethod.PUT)
	public Athlete create(Athlete athlete) {
		return athleteService.save(athlete);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Athlete update(Athlete athlete) {
		return athleteService.update(athlete);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		athleteService.delete(id);
	}
	
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public Athlete view(@PathVariable Long id) {
		return athleteService.findById(id);
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Athlete> list() {
		return athleteService.findAll();
	}
}
