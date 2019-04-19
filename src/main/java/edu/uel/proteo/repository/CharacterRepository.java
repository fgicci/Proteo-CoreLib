package edu.uel.proteo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import edu.uel.proteo.model.Character;

@Repository
public interface CharacterRepository extends MongoRepository<Character, Long> {}
