package com.casadocodigo.controller;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.casadocodigo.dao.BookDAO;
import com.casadocodigo.model.Book;

@Model
public class BookDetailsBean {

	@Inject
	private BookDAO bookDAO;
	
	private Book book;
	
	private Integer id;
	
	
	public void loadBook() {
		book = bookDAO.findOne(id);
	}

	public Book getBook() {
		return book;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
}
