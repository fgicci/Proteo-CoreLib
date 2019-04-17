package edu.uel.proteo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uel.proteo.services.SportService;

@RestController
@RequestMapping("/sport")
public class SportController {

	@Autowired
	private SportService sportService;
	
	@RequestMapping("/list")
	public List<String> list() {
		return sportService.getAllNames();
	}
}
