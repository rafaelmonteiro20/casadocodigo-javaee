package com.casadocodigo.controller;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.servlet.http.Part;
import javax.transaction.Transactional;

import com.casadocodigo.dao.AuthorDAO;
import com.casadocodigo.dao.BookDAO;
import com.casadocodigo.infra.FileSaver;
import com.casadocodigo.infra.jsf.MessagesHelper;
import com.casadocodigo.model.Author;
import com.casadocodigo.model.Book;

@Model
public class AdminBooksBean {
	
	@Inject
	private BookDAO bookDAO;
	
	@Inject
	private AuthorDAO authorDAO;
	
	@Inject
	private FileSaver fileSaver;

	@Inject
	private MessagesHelper messagesHelper;
	
	private Part cover;

	private Book book = new Book();
	
	private List<Author> authors;
	
	private List<Integer> selectedAuthorsIds;
	
	@Transactional
	public String save() {
		pupulateBookAuthors();
		
		String coverPath = fileSaver.write("covers", cover);
		book.setCoverPath(coverPath);
		
		bookDAO.save(book);
		messagesHelper.addFlash("Livro salvo com sucesso");
		return "/books/list?faces-redirect=true";
	}
	
	private void pupulateBookAuthors() {
		selectedAuthorsIds.stream().map(id -> new Author(id)).forEach(book::addAuthor);
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
	
	public List<Author> getAuthors() {
		if(authors == null)
			authors = authorDAO.findAll();
		
		return authors;
	}
	
	public List<Integer> getSelectedAuthorsIds() {
		return selectedAuthorsIds;
	}
	
	public void setSelectedAuthorsIds(List<Integer> selectedAuthorsIds) {
		this.selectedAuthorsIds = selectedAuthorsIds;
	}
	
}
