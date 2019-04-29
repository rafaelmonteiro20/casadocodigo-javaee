package com.casadocodigo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.casadocodigo.model.Customer;

public class CustomerDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void save(Customer customer) {
		manager.persist(customer);
	}
	
}
