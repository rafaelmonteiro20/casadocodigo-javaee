package com.casadocodigo.service;

import javax.inject.Inject;
import javax.servlet.http.Part;
import javax.transaction.Transactional;

import com.casadocodigo.dao.BookDAO;
import com.casadocodigo.model.Book;
import com.casadocodigo.storage.FileSaver;

public class BookService {

	private static final String DIRECTORY = "covers";
	
	@Inject
	private BookDAO bookDAO;
	
	@Inject
	private FileSaver fileSaver;

	@Transactional
	public void save(Book book, Part cover) {
		String coverPath = fileSaver.write(DIRECTORY, cover);
		book.setCoverPath(coverPath);
		bookDAO.save(book);
	}
	
}
