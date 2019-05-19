package edu.uel.proteo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uel.proteo.model.Trial;
import edu.uel.proteo.services.TrialService;

@RestController
@RequestMapping("/trial")
public class TrialController extends StdRecordController<Trial, Long> {

	@Autowired
	public TrialController(TrialService trialService) {
		super(trialService);
	}
}
