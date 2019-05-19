package edu.uel.proteo.repository;

import org.springframework.stereotype.Repository;

import edu.uel.proteo.model.Characteristic;

@Repository("characteristicRepository")
public interface CharacteristicRepository extends StdRecordRepository<Characteristic, Long> {}
