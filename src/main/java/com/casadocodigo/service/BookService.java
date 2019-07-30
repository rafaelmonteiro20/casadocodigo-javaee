package com.casadocodigo.service;

import javax.inject.Inject;
import javax.servlet.http.Part;
import javax.transaction.Transactional;

import com.casadocodigo.dao.BookDAO;
import com.casadocodigo.infra.FileSaver;
import com.casadocodigo.model.Book;

public class BookService {

	@Inject
	private BookDAO bookDAO;
	
	@Inject
	private FileSaver fileSaver;

	@Transactional
	public void save(Book book, Part cover) {
		String coverPath = fileSaver.write("covers", cover);
		book.setCoverPath(coverPath);
		bookDAO.save(book);
	}
	
}
