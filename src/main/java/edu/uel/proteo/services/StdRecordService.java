package edu.uel.proteo.services;

import java.io.Serializable;
import java.util.List;

public interface StdRecordService<E, K extends Serializable> {

	E findById(K key);
	List<E> findAll();
	E save(E entity);
	E update(E entity);
	void delete(K key);
	void remove(E entity);
}
