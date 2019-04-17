package edu.uel.proteo.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uel.proteo.model.Sport;

@RestController
@RequestMapping("/sport")
public class SportController {

	@RequestMapping("/list")
	public List<String> getAll() {
		return Arrays.asList(Sport.values()).stream().map(Sport::name).collect(Collectors.toList());
	}
}
