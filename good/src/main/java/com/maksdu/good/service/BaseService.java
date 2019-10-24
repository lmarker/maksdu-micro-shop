package com.maksdu.good.service;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseService<T> {

	void setRepository(JpaRepository<T,String> repository);
	
	T save(T entity);
	
	T update(T entity);
	
	T getOne(String entityId);
	
	T delete(T entity);
	
	List<T> saveAll(Collection<T> collection);
	
	List<T> selectAll();
}
