package edu.uel.proteo.services;

import java.io.Serializable;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import edu.uel.proteo.exception.ResourceNotFoundException;
import edu.uel.proteo.model.Record;
import edu.uel.proteo.model.Record_;
import edu.uel.proteo.repository.StdRecordRepository;
import edu.uel.proteo.utils.RecordUtils;

public abstract class StdRecordServiceImpl<T extends Record, ID extends Serializable> implements StdRecordService<T, ID> {

	private static final String CLASS_NAME = "Record";
	private StdRecordRepository<T, ID> repository;
	
	@Autowired
 	public StdRecordServiceImpl(StdRecordRepository<T, ID> repository) {
		this.repository = repository;
	}
	
	@Override
	public T findById(ID id) {
		return repository.findById(id).
		orElseThrow(() -> new ResourceNotFoundException(CLASS_NAME, "id", String.valueOf(id))); 
	}

	@Override
	public List<T> findAll(Integer pageNumber, Integer limit) {
		return repository.findAll(new Specification<T>() {
			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.<Boolean>get(Record_.active), RecordUtils.ACTIVE);
			}
		}, PageRequest.of(pageNumber, limit)).getContent();
	}

	@Override
	public T create(T entity) {
		return null;
	}

	@Override
	public T update(T entity) {
		return null;
	}

	@Override
	public void delete(ID id) {		
	}

	@Override
	public void remove(T entity) {		
	}
}
