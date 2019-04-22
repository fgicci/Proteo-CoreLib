package edu.uel.proteo.services;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.uel.proteo.exception.ResourceNotFoundException;
import edu.uel.proteo.model.Athlete;
import edu.uel.proteo.model.Athlete_;
import edu.uel.proteo.repository.AthleteRepository;
import edu.uel.proteo.utils.RecordUtils;

@Service
public class AthleteServiceImpl implements AthleteService {
	
	@Autowired
	private AthleteRepository athleteRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Athlete findById(Long id) {
		return athleteRepository.findById(id).
		orElseThrow(() -> new ResourceNotFoundException("Athlete", "id", String.valueOf(id))); 
	}

	@Override
	@Transactional(readOnly = true)
	public List<Athlete> findAll() {
		return athleteRepository.findAll(new Specification<Athlete>() {
			@Override
			public Predicate toPredicate(Root<Athlete> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.<Boolean>get(Athlete_.active), RecordUtils.ACTIVE);
			}
		});
	}

	@Override
	@Transactional
	public Athlete save(Athlete athlete) {
		athlete.setActive(RecordUtils.ACTIVE);
		return athleteRepository.save(athlete);
	}

	@Override
	@Transactional
	public Athlete update(Athlete athlete) {
		findById(athlete.getId());
		if (athlete.getActive() == null) athlete.setActive(RecordUtils.ACTIVE);
		return athleteRepository.save(athlete);
	}

	@Override
	public void delete(Long id) {
		Athlete athlete = findById(id);
		athlete.setActive(RecordUtils.INACTIVE);
		athleteRepository.save(athlete);
	}

	@Override
	public void remove(Athlete athlete) {
		athleteRepository.delete(athlete);
	}

}
