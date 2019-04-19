package edu.uel.proteo.services;

import java.io.Serializable;
import java.util.List;

public interface StdDocumentService<T, I extends Serializable> {

	T findById(I id);
	List<T> findAll();
	T save(T type);
	T update(T type);
	void delete(I id);
}
