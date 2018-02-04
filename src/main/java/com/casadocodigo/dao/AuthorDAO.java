package com.casadocodigo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.casadocodigo.model.Author;

public class AuthorDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public List<Author> findAll() {
		return manager.createQuery("from Author", Author.class)
					.getResultList();
	}
	
}
