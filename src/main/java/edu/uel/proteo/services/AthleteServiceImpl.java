package edu.uel.proteo.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uel.proteo.model.Athlete;
import edu.uel.proteo.repository.AthleteRepository;

@Service
public class AthleteServiceImpl implements AthleteService {

	@Autowired
	private AthleteRepository athleteRepository;
	
	
	@Override
	public Athlete findById(Long id) {
		return athleteRepository.findById(id).get();
	}

	@Override
	public List<Athlete> findAll() {
		return athleteRepository.findAll();
	}

	@Override
	public Athlete save(Athlete athlete) {
		athlete.setCreateDate(new Date());
		athlete.setUpdateDate(new Date());
		return athleteRepository.save(athlete);
	}

	@Override
	public Athlete update(Athlete athlete) {
		athlete.setUpdateDate(new Date());
		return athleteRepository.save(athlete);
	}

	@Override
	public void delete(Long id) {
		if (athleteRepository.existsById(id))
			athleteRepository.deleteById(id);
	}

}
