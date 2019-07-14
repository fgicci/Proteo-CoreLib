package edu.uel.proteo.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/view/{id}")
	public T view(@PathVariable ID id) {
		return service.findById(id);
	}
	
	@PutMapping("/create")
	public T create(@RequestBody T type) {
		return service.create(type);
	}
	
	@PostMapping("/update/{id}")
	public T update(@PathVariable ID id, @RequestBody T type) {
		service.findById(id);
		return service.update(type);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable ID id) {
		service.findById(id);
		service.delete(id);
	}
}
