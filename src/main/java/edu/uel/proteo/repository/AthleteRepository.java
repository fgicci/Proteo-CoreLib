package edu.uel.proteo.repository;

import org.springframework.stereotype.Repository;

import edu.uel.proteo.model.Athlete;

@Repository("athleteRepository")
public interface AthleteRepository extends StdRecordRepository<Athlete, Long> {}
