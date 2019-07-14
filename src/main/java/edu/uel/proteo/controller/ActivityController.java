package edu.uel.proteo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uel.proteo.model.Activity;
import edu.uel.proteo.services.ActivityService;

@RestController
@RequestMapping("/activity")
public class ActivityController extends StdRecordController<Activity, Long> {

	@Autowired
	public ActivityController(ActivityService activityService) {
		super(activityService);
	}
}
