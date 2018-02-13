package com.casadocodigo.session;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.casadocodigo.model.ShoppingItem;

@Named
@SessionScoped
public class ShoppingCart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<ShoppingItem, Integer> items = new LinkedHashMap<>();
	
	
	public void add(ShoppingItem item) {
		items.put(item, getQuantity(item) + 1);
	}

	public int getQuantity(ShoppingItem item) {
		return items.getOrDefault(item, 0);
	}
	
	public int getQuantity() {
		return items.values().stream().reduce(0, (next, accumulator) -> next + accumulator);
	}
	
}
