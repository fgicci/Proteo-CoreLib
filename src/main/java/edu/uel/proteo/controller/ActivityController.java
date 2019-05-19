package edu.uel.proteo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.uel.proteo.model.Activity;
import edu.uel.proteo.services.ActivityService;

@RestController
@RequestMapping("/activity")
public class ActivityController {

	@Autowired
	private ActivityService activityService;
	
	@RequestMapping(value = "/create", method = RequestMethod.PUT)
	public Activity create(@RequestBody Activity activity) {
		return activityService.create(activity);
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public Activity update(@PathVariable Long id, @RequestBody Activity activity) {
		activityService.findById(id);
		return activityService.update(activity);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		activityService.findById(id);
		activityService.delete(id);
	}
	
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public Activity view(@PathVariable Long id) {
		return activityService.findById(id);
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Activity> list() {
		return activityService.findAll(0, 20);
	}
}
