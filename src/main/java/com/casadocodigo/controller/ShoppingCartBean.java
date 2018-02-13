package com.casadocodigo.controller;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.casadocodigo.dao.BookDAO;
import com.casadocodigo.model.Book;
import com.casadocodigo.model.ShoppingItem;
import com.casadocodigo.session.ShoppingCart;

@Model
public class ShoppingCartBean {

	@Inject
	private ShoppingCart shoppingCart;
	
	@Inject
	private BookDAO bookDAO;
	
	public String add(Integer bookID) {
		ShoppingItem item = createItem(bookID);
		shoppingCart.add(item);
		return "/cart.xhtml?faces-redirect=true";
	}
	
	private ShoppingItem createItem(Integer bookID) {
		Book book = bookDAO.findOne(bookID);
		return new ShoppingItem(book);
	}
	
}
