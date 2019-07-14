package edu.uel.proteo.repository;

import org.springframework.stereotype.Repository;

import edu.uel.proteo.model.Activity;

@Repository("activityRepository")
public interface ActivityRepository extends StdRecordRepository<Activity, Long> {}
