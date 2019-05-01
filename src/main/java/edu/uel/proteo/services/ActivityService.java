package edu.uel.proteo.services;

import java.util.List;

import edu.uel.proteo.model.Activity;
import edu.uel.proteo.model.Athlete;
import edu.uel.proteo.model.Protocol;

public interface ActivityService extends StdRecordService<Activity, Long> {
	
	List<Activity> findByProtocol(Protocol protocol);
	List<Activity> findByAthlete(Athlete athlete);
}
