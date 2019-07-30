package com.casadocodigo.controller;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.servlet.http.Part;
import javax.validation.constraints.NotNull;

import com.casadocodigo.dao.AuthorDAO;
import com.casadocodigo.infra.jsf.MessagesHelper;
import com.casadocodigo.model.Author;
import com.casadocodigo.model.Book;
import com.casadocodigo.model.Category;
import com.casadocodigo.service.BookService;
import com.casadocodigo.service.exception.BookException;

@Model
public class AdminBooksBean {
	
	@Inject
	private BookService bookService;
	
	@Inject
	private AuthorDAO authorDAO;

	@Inject
	private MessagesHelper messagesHelper;
	
	@NotNull
	private Part cover;

	private Book book = new Book();
	
	private List<Author> authors;
	private List<Integer> selectedAuthorsIds;
	
	
	public String save() {
		pupulateBookAuthors();
		
		try {
			bookService.save(book, cover);
			messagesHelper.addFlash("Livro salvo com sucesso");
			return "/books/list?faces-redirect=true";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private void pupulateBookAuthors() {
		selectedAuthorsIds.stream().map(id -> new Author(id))
				.forEach(book::addAuthor);
	}
	
	public List<Author> getAuthors() {
		if(authors == null) {
			authors = authorDAO.findAll();
		}
		return authors;
	}
	
	public Book getBook() {
		return book;
	}
	
	public Part getCover() {
		return cover;
	}
	
	public void setCover(Part cover) {
		this.cover = cover;
	}
	
	public Category[] getCategories() {
		return Category.values();
	}
	
	public List<Integer> getSelectedAuthorsIds() {
		return selectedAuthorsIds;
	}
	
	public void setSelectedAuthorsIds(List<Integer> selectedAuthorsIds) {
		this.selectedAuthorsIds = selectedAuthorsIds;
	}
	
}
