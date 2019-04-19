package edu.uel.proteo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import edu.uel.proteo.model.Athlete;

@Repository
public interface AthleteRepository extends MongoRepository<Athlete, Long> {}
