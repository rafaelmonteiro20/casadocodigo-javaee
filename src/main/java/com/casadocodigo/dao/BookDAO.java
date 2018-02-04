package com.casadocodigo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.casadocodigo.model.Book;

public class BookDAO {
	
	@PersistenceContext
	private EntityManager manager;

	public void save(Book book) {
		manager.merge(book);
	}

}
