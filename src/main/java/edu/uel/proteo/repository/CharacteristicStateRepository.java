package edu.uel.proteo.repository;

import org.springframework.stereotype.Repository;

import edu.uel.proteo.model.CharacteristicState;

@Repository("characteristicStateRepository")
public interface CharacteristicStateRepository extends StdRecordRepository<CharacteristicState, Long> {}
