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
import edu.uel.proteo.model.Activity;
import edu.uel.proteo.model.Activity_;
import edu.uel.proteo.model.Protocol;
import edu.uel.proteo.repository.ActivityRepository;
import edu.uel.proteo.utils.RecordUtils;

@Service
public class ActivityServiceImpl implements ActivityService {
	
	@Autowired
	private ActivityRepository activityRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Activity findById(Long id) {
		return activityRepository.findById(id).
		orElseThrow(() -> new ResourceNotFoundException("Activity", "id", String.valueOf(id))); 
	}

	@Override
	@Transactional(readOnly = true)
	public List<Activity> findAll() {
		return activityRepository.findAll(new Specification<Activity>() {
			@Override
			public Predicate toPredicate(Root<Activity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.<Boolean>get(Activity_.active), RecordUtils.ACTIVE);
			}
		});
	}

	@Override
	@Transactional(readOnly = true)
	public List<Activity> findByProtocol(Protocol protocol) {
		return activityRepository.findAll(new Specification<Activity>() {
			@Override
			public Predicate toPredicate(Root<Activity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.<Protocol>get(Activity_.protocol), protocol);
			}
		});
	}
	
	@Override
	@Transactional
	public Activity save(Activity activity) {
		activity.setActive(RecordUtils.ACTIVE);
		return activityRepository.save(activity);
	}

	@Override
	@Transactional
	public Activity update(Activity activity) {
		findById(activity.getId());
		if (activity.getActive() == null) activity.setActive(RecordUtils.ACTIVE);
		return activityRepository.save(activity);
	}

	@Override
	public void delete(Long id) {
		Activity activity = findById(id);
		activity.setActive(RecordUtils.INACTIVE);
		activityRepository.save(activity);
	}

	@Override
	public void remove(Activity activity) {
		activityRepository.delete(activity);
	}

}
