package edu.uel.proteo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uel.proteo.model.Athlete;
import edu.uel.proteo.repository.AthleteRepository;

@Service
public class AthleteServiceImpl extends StdRecordServiceImpl<Athlete, Long> implements AthleteService {
	
	AthleteRepository athleteReposirory;
	
	@Autowired
	public AthleteServiceImpl(AthleteRepository athleteReposirory) {
		super(athleteReposirory, Athlete.class);
		this.athleteReposirory = athleteReposirory;
	}
}
