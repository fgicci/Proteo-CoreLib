package edu.uel.proteo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.uel.proteo.model.Protocol;
import edu.uel.proteo.services.ProtocolService;
import edu.uel.proteo.services.StatisticsService;
import edu.uel.proteo.statistics.PlayerDistanceResult;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

	@Autowired
	private ProtocolService protocolService;
	
	@Autowired
	private StatisticsService statisticsService;
	
	@RequestMapping(value = "/distance", method = RequestMethod.GET)
	public List<PlayerDistanceResult> getDistanceList(@RequestParam("protocolId") Long id) {
		Protocol protocol = protocolService.findById(id);
		return statisticsService.getDistanceFromAllPlayers(protocol);
	}
}
