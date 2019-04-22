package edu.uel.proteo.services;

import java.util.List;

import edu.uel.proteo.model.Protocol;
import edu.uel.proteo.statistics.PlayerDistanceResult;

public interface StatisticsService {

	public List<PlayerDistanceResult> getDistanceFromAllPlayers(Protocol protocol);
}
