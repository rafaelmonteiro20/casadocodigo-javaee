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
	
	public Book findOne(Integer bookID) {
		try {
		return manager.createQuery("select b from Book b join fetch b.authors where b.id = :bookID", Book.class)
				.setParameter("bookID", bookID)
				.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	public List<Book> findAll() {
		return manager.createQuery("select distinct(b) from Book b join fetch b.authors", Book.class)
				.getResultList();
	}

	public List<Book> lastReleases() {
		return manager.createQuery("from Book order by releaseDate desc", Book.class)
				.setMaxResults(5)
				.getResultList();
	}

	public List<Book> olderBooks() {
		return manager.createQuery("from Book order by releaseDate desc", Book.class)
				.setFirstResult(5)
				.getResultList();
	}

}
