package edu.uel.proteo.services;

import java.util.List;

import edu.uel.proteo.model.Activity;
import edu.uel.proteo.model.Protocol;

public interface ActivityService extends StdRecordService<Activity, Long> {
	
	List<Activity> findByProtocol(Protocol protocol);
}
