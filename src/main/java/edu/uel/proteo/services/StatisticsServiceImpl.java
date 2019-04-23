package edu.uel.proteo.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uel.proteo.model.Activity;
import edu.uel.proteo.model.Athlete;
import edu.uel.proteo.model.Characteristic;
import edu.uel.proteo.model.Protocol;
import edu.uel.proteo.statistics.PlayerDistanceResult;
import edu.uel.proteo.utils.StatisticsUtils;

@Service
public class StatisticsServiceImpl implements StatisticsService {

	@Autowired
	private ActivityService activityService;
	
	@Override
	public List<PlayerDistanceResult> getDistanceFromAllPlayers(Protocol protocol) {
		List<PlayerDistanceResult> results = new ArrayList<PlayerDistanceResult>();
		final Double[] optimunValues = protocol.getCharacteristics()
				.stream()
				.map(Characteristic::getOptimum)
				.collect(Collectors.toList())
				.toArray(new Double[protocol.getCharacteristics().size()]);
		
		for (Map.Entry<Athlete, List<Activity>> athleteActivity : activityService.findByProtocol(protocol)
				.stream().
				collect(Collectors.groupingBy(Activity::getAthlete))
				.entrySet()) {
			Double[] characteristicValues = athleteActivity.getValue()
					.stream()
					.map(Activity::getValue)
					.collect(Collectors.toList())
					.toArray(new Double[athleteActivity.getValue().size()]);
			
			PlayerDistanceResult playerDistanceResult = new PlayerDistanceResult();
			playerDistanceResult.setName(athleteActivity.getKey().getFullName());
			playerDistanceResult.setDistance(StatisticsUtils.euclidianDistance(optimunValues, characteristicValues));
			playerDistanceResult.setValues(athleteActivity.getValue().stream().collect(Collectors.toMap(Activity::getCharacteristicName, Activity::getValue)));
			results.add(playerDistanceResult);
		}
		
		Collections.sort(results, new Comparator<PlayerDistanceResult>() {
			@Override
			public int compare(PlayerDistanceResult pdr1, PlayerDistanceResult pdr2) {
				return Double.compare(pdr1.getDistance(), pdr2.getDistance());
			}
		});
		return results;
	}

}
