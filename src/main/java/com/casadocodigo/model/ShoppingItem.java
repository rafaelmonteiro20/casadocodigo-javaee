package com.casadocodigo.model;

import java.math.BigDecimal;

public class ShoppingItem {

	private Book book;
	
	private Integer bookID;
	
	public ShoppingItem(Book book) {
		this.book = book;
		this.bookID = book.getId();
	}
	
	public Book getBook() {
		return book;
	}
	
	public Integer getBookID() {
		return bookID;
	}
	
	public BigDecimal getPreco() {
		return book.getPrice();
	}
	
	public BigDecimal getTotal(int quantidade) {
		return getPreco().multiply(new BigDecimal(quantidade));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookID == null) ? 0 : bookID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoppingItem other = (ShoppingItem) obj;
		if (bookID == null) {
			if (other.bookID != null)
				return false;
		} else if (!bookID.equals(other.bookID))
			return false;
		return true;
	}
	
}

