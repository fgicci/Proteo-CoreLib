package edu.uel.proteo.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.uel.proteo.model.Record;
import edu.uel.proteo.services.StdRecordService;

public class StdRecordController<T extends Record, ID extends Serializable> {

	private StdRecordService<T, ID> service;
	
	@Autowired
	public StdRecordController(StdRecordService<T, ID> service) {
		this.service = service;
	}

	@GetMapping("/list")
	public List<T> getList(@RequestParam Integer pageNumber, @RequestParam Integer limit) {
		return service.findAll(pageNumber, limit);
	}
}
