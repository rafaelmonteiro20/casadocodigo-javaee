package com.casadocodigo.controller;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

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
	
	@Transactional
	public String save() {
		subcategoryDAO.save(subcategory);
		messagesHelper.addFlash("Categoria salva com sucesso!");
		return "/categories/list.xhtml?faces-redirect=true";
	}

	public Category[] getCategories() {
		return Category.values();
	}
	
	public Subcategory getSubcategory() {
		return subcategory;
	}
	
}
