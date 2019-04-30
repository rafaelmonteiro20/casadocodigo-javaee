package com.casadocodigo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.casadocodigo.model.Subcategory;

public class SubcategoryDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public Subcategory save(Subcategory subcategory) {
		if(subcategory.isNew()) {
			manager.persist(subcategory);
			return subcategory;
		}
		
		return manager.merge(subcategory);
	}
	
}
