package edu.uel.proteo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.uel.proteo.model.Protocol;
import edu.uel.proteo.services.CharacteristicService;
import edu.uel.proteo.services.ProtocolService;

@RestController
@RequestMapping("/protocol")
public class ProtocolController {

	@Autowired(required = true)
	private ProtocolService protocolService;
	
	@Autowired
	private CharacteristicService characteristicService;
	
	@RequestMapping(value = "/create", method = RequestMethod.PUT)
	public Protocol create(@RequestBody Protocol protocol) {
		return protocolService.save(protocol);
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public Protocol update(@PathVariable Long id, @RequestBody Protocol protocol) {
		protocolService.findById(id);
		return protocolService.update(protocol);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		protocolService.findById(id);
		protocolService.delete(id);
	}
	
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public Protocol view(@PathVariable Long id) {
		return protocolService.findById(id);
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Protocol> list() {
		return protocolService.findAll();
	}
	
	@RequestMapping(value = "/add/{id}", method = RequestMethod.POST)
	public Protocol view(@PathVariable Long id, @RequestParam Long characteristicId) {
		return protocolService.add(protocolService.findById(id), characteristicService.findById(characteristicId));
	}
}
