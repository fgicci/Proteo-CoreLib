package edu.uel.proteo.services;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import edu.uel.proteo.exception.RecordExistsException;
import edu.uel.proteo.exception.RecordNotFoundException;
import edu.uel.proteo.model.Record;
import edu.uel.proteo.model.Record_;
import edu.uel.proteo.repository.StdRecordRepository;
import edu.uel.proteo.utils.RecordUtils;

public abstract class StdRecordServiceImpl<T extends Record, ID extends Serializable>
		implements StdRecordService<T, ID> {

	private static final String DEFAULT_CLASS_NAME = "Record";
	private static final String ID_FIELD = "id";
	private String className = DEFAULT_CLASS_NAME;
	private StdRecordRepository<T, ID> repository;

	@Autowired
	public StdRecordServiceImpl(StdRecordRepository<T, ID> repository, Class<T> clazz) {
		this.repository = repository;
		this.className = clazz.getName();
	}

	@Override
	public T findById(ID id) {
		return repository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException(className, ID_FIELD, String.valueOf(id)));
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
	public T create(T type) {
		if ((ID) type.getId() != null && repository.existsById((ID) type.getId()))
			throw new RecordExistsException(className, ID_FIELD, String.valueOf(type.getId()));
		type.setCreateDate(new Date());
		type.setUpdateDate(new Date());
		type.setActive(true);
		return repository.save(type);
	}

	@Override
	public T update(T type) {
		if (!repository.existsById(((ID) type.getId())))
			throw new RecordNotFoundException(className, ID_FIELD, String.valueOf(type.getId()));
		type.setUpdateDate(new Date());
		return repository.save(type);
	}

	@Override
	public void delete(ID id) {
		T type = findById(id);
		type.setActive(false);
		update(type);
	}

	@Override
	public void remove(T type) {
		if (!repository.existsById(((ID) type.getId())))
			throw new RecordNotFoundException(className, ID_FIELD, String.valueOf(type.getId()));
		repository.delete(type);
	}
}
