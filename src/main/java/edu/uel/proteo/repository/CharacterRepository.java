package edu.uel.proteo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import edu.uel.proteo.model.Character;

@Repository
public interface CharacterRepository
	extends JpaRepository<Character, Long>, JpaSpecificationExecutor<Character> {}
