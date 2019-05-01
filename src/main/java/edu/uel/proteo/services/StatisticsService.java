package edu.uel.proteo.services;

import java.util.List;

import edu.uel.proteo.model.Athlete;
import edu.uel.proteo.model.Protocol;
import edu.uel.proteo.statistics.PlayerDistanceResult;
import edu.uel.proteo.statistics.Chart;

public interface StatisticsService {

	public List<PlayerDistanceResult> getDistanceFromAllPlayers(Protocol protocol);
	public Chart getRadarData(Protocol protocol, Athlete athlete);
}
