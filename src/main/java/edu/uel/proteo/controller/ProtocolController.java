package edu.uel.proteo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.uel.proteo.model.Protocol;
import edu.uel.proteo.services.CharacteristicService;
import edu.uel.proteo.services.ProtocolService;

@RestController
@RequestMapping("/protocol")
public class ProtocolController extends StdRecordController<Protocol, Long> {

	@Autowired
	private CharacteristicService characteristicService;

	private ProtocolService protocolService;
	
	@Autowired
	public ProtocolController(ProtocolService protocolService) {
		super(protocolService);
		this.protocolService = protocolService;
	}

	@RequestMapping(value = "/add/{id}", method = RequestMethod.POST)
	public Protocol view(@PathVariable Long id, @RequestParam Long characteristicId) {
		return protocolService.add(protocolService.findById(id), characteristicService.findById(characteristicId));
	}
}
