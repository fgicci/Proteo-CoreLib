package edu.uel.proteo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import edu.uel.proteo.model.CharacterState;

@Repository
public interface CharacterStateRepository 
	extends JpaRepository<CharacterState, Long>, JpaSpecificationExecutor<CharacterState> {}
