package edu.uel.proteo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import edu.uel.proteo.model.CharacteristicState;

@Repository
public interface CharacteristicStateRepository 
	extends JpaRepository<CharacteristicState, Long>, JpaSpecificationExecutor<CharacteristicState> {}
