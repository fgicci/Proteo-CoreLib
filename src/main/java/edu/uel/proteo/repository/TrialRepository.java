package edu.uel.proteo.repository;

import org.springframework.stereotype.Repository;

import edu.uel.proteo.model.Trial;

@Repository("trialRepository")
public interface TrialRepository extends StdRecordRepository<Trial, Long> {}
