package com.casadocodigo.controller;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.casadocodigo.dao.BookDAO;
import com.casadocodigo.model.Book;

@Model
public class HomeBean {

	@Inject
	private BookDAO bookDAO;
	
	public List<Book> lastReleases() {
		return bookDAO.lastReleases();
	}
	
	public List<Book> olderBooks() {
		return bookDAO.olderBooks();
	}
	
}
