package com.casadocodigo.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.casadocodigo.dao.BookDAO;
import com.casadocodigo.model.Book;

@Model
public class AdminListBooksBean {

	@Inject
	private BookDAO bookDAO;
	
	private List<Book> books;
	
	@PostConstruct
	private void init() {
		books = bookDAO.findAll();
	}
	
	public List<Book> getBooks() {
		return books;
	}
	
}
