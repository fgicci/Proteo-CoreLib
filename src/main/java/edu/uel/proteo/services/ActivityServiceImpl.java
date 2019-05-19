package edu.uel.proteo.services;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.uel.proteo.model.Activity;
import edu.uel.proteo.model.Activity_;
import edu.uel.proteo.model.Athlete;
import edu.uel.proteo.model.Protocol;
import edu.uel.proteo.repository.ActivityRepository;

@Service
public class ActivityServiceImpl extends StdRecordServiceImpl<Activity, Long> implements ActivityService {
	
	ActivityRepository activityRepository;
	
	@Autowired
	public ActivityServiceImpl(ActivityRepository activityRepository) {
		super(activityRepository);
		this.activityRepository = activityRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Activity> findByProtocol(Protocol protocol) {
		return activityRepository.findAll(new Specification<Activity>() {
			@Override
			public Predicate toPredicate(Root<Activity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.<Protocol>get(Activity_.protocol), protocol);
			}
		}, new Sort(Sort.Direction.ASC, "characteristic"));
	}
	
	@Override
	public List<Activity> findByAthlete(Athlete athlete) {
		return activityRepository.findAll(new Specification<Activity>() {
			@Override
			public Predicate toPredicate(Root<Activity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.<Athlete>get(Activity_.athlete), athlete);
			}
		}, new Sort(Sort.Direction.ASC, "characteristic"));
	}
}
