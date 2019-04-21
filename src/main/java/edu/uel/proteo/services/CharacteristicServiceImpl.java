package edu.uel.proteo.services;

import java.util.Iterator;
import java.util.List;

import javax.persistence.LockModeType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.uel.proteo.exception.ResourceNotFoundException;
import edu.uel.proteo.model.Characteristic;
import edu.uel.proteo.model.CharacteristicState;
import edu.uel.proteo.model.Characteristic_;
import edu.uel.proteo.repository.CharacteristicRepository;
import edu.uel.proteo.utils.RecordUtils;

@Service
public class CharacteristicServiceImpl implements CharacteristicService {
	
	@Autowired
	private CharacteristicRepository cr;
	
	@Override
	@Transactional(readOnly = true)
	public Characteristic findById(Long id) {
		return cr.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Characteristic", "id", id.toString()));
	}

	@Override
	@Transactional(readOnly = true)
	public List<Characteristic> findAll() {
		return cr.findAll(new Specification<Characteristic>() {
			@Override
			public Predicate toPredicate(Root<Characteristic> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.<Boolean>get(Characteristic_.active), RecordUtils.ACTIVE);
			}
		});
	}

	@Override
	@Transactional
	public Characteristic save(Characteristic characteristic) {
		characteristic.setActive(RecordUtils.ACTIVE);
		return cr.save(characteristic);
	}

	@Override
	@Transactional
	@Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
	public Characteristic update(Characteristic characteristic) {
		findById(characteristic.getId());
		if (characteristic.getActive() == null) characteristic.setActive(RecordUtils.ACTIVE);
		return cr.save(characteristic);
	}

	@Override
	public void delete(Long id) {
		Characteristic characteristic = findById(id);
		characteristic.setActive(RecordUtils.INACTIVE);
		update(characteristic);
	}

	@Override
	public void remove(Characteristic characteristic) {
		cr.delete(characteristic);
	}

	@Override
	public Characteristic add(Characteristic characteristic, CharacteristicState state) {
		characteristic.addState(state);
		return update(characteristic);
	}

	@Override
	@Transactional
	@Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
	public Characteristic addAll(Characteristic characteristic, Iterator<CharacteristicState> state) {
		// TODO Auto-generated method stub
		return null;
	}
}
