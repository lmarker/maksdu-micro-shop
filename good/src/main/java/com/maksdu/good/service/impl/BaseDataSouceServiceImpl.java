package com.maksdu.good.service.impl;

import java.lang.ref.SoftReference;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maksdu.good.domain.DomainBase;
import com.maksdu.good.exception.GoodPreparedFailedSupport;
import com.maksdu.good.service.BaseService;

public abstract class BaseDataSouceServiceImpl<T extends DomainBase> implements BaseService<T> {

	private JpaRepository<T, String> repository;
	
	@Override
	public T save(T entity) {
		if(repository == null) {
			setRepository(repository);
		}
		if(repository == null)
			throw new GoodPreparedFailedSupport();
		return repository.save(entity);
	}

	@Override
	public T update(T entity) {
		if(repository == null) {
			setRepository(repository);
		}
		if(repository == null)
			throw new GoodPreparedFailedSupport();
		return repository.saveAndFlush(entity);
	}

	@Override
	public T getOne(String entityId) {
		if(repository == null) {
			setRepository(repository);
		}
		if(repository == null)
			throw new GoodPreparedFailedSupport();
		return repository.getOne(entityId);
	}

	@Override
	public T delete(T entity) {
		if(repository == null) {
			setRepository(repository);
		}
		if(repository == null)
			throw new GoodPreparedFailedSupport();
		repository.delete(entity);
		return entity;
	}

	@Override
	public List<T> saveAll(Collection<T> collection) {
		if(repository == null) {
			setRepository(repository);
		}
		if(repository == null)
			throw new GoodPreparedFailedSupport();
		return repository.saveAll(collection);
	}

	@Override
	public List<T> selectAll() {
		if(repository == null) {
			setRepository(repository);
		}
		if(repository == null)
			throw new GoodPreparedFailedSupport();
		return repository.findAll();
	}

	@Override
	public void setRepository(JpaRepository<T,String> repository) {
		this.repository = repository;
	}

}
