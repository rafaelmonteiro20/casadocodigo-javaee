package com.casadocodigo.controller;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.casadocodigo.dao.BookDAO;
import com.casadocodigo.model.Book;

@Model
public class AdminBooksBean {
	
	@Inject
	private BookDAO bookDAO;

	private Book book = new Book();
	
	@Transactional
	public void save() {
		bookDAO.save(book);
		System.out.println("Livro salvo com sucesso.");
	}
	
	public Book getBook() {
		return book;
	}
	
}
