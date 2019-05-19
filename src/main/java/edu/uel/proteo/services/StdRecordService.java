package edu.uel.proteo.services;

import java.io.Serializable;
import java.util.List;

public abstract interface StdRecordService<T, ID extends Serializable> {

	T findById(ID id);
	List<T> findAll(Integer pageNumber, Integer limit);
	T create(T entity);
	T update(T entity);
	void delete(ID id);
	void remove(T entity);
}
