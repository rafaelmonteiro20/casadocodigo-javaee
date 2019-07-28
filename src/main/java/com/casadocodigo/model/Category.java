package com.casadocodigo.model;

public enum Category {

	PROGRAMMING("Programação"),
	MOBILE("Mobile"),
	FRONT_END("Front-end"),
	INFRASTRUCTURE("Infraestrutura"),
	BUSINESS("Business"),
	DESIGN_UX("Design & UX");
	
	private String description;
	
	private Category(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
}
