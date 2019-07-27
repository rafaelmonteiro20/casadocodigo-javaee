package com.casadocodigo.controller;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.casadocodigo.dao.AuthorDAO;
import com.casadocodigo.infra.jsf.MessagesHelper;
import com.casadocodigo.model.Author;

@Model
public class AuthorBean {

	@Inject
	private AuthorDAO authorDAO;
	
	@Inject
	private MessagesHelper messagesHelper;
	
	private Author author = new Author();
	
	@Transactional
	public String save() {
		authorDAO.save(author);
		messagesHelper.addFlash("Autor salvo com sucesso!");
		return "/authors/list.xhtml?faces-redirect=true";
	}

	public Author getAuthor() {
		return author;
	}
	
}
