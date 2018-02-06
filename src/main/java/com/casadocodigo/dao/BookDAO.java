package com.casadocodigo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.casadocodigo.model.Book;

public class BookDAO {
	
	@PersistenceContext
	private EntityManager manager;

	public void save(Book book) {
		manager.merge(book);
	}

	public List<Book> findAll() {
		return manager.createQuery("select distinct(b) from Book b join fetch b.authors", 
				Book.class).getResultList();
	}

}
