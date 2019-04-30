package com.casadocodigo.controller;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.casadocodigo.dao.SubcategoryDAO;
import com.casadocodigo.infra.jsf.MessagesHelper;
import com.casadocodigo.model.Category;
import com.casadocodigo.model.Subcategory;

@Model
public class AdminCategoriesBean {

	@Inject
	private SubcategoryDAO subcategoryDAO;
	
	@Inject
	private MessagesHelper messagesHelper;
	
	private Subcategory subcategory = new Subcategory();
	
	
	public void save() {
		System.out.println("Chegou..." + subcategory);
	}
	
	public String teste() {
		return "/home.xhtml?faces-redirect=true";
	}

	public Category[] getCategories() {
		return Category.values();
	}
	
	public Subcategory getSubcategory() {
		return subcategory;
	}
	
}
