package com.casadocodigo.model;

public interface Identifiable<T> {

	T getId();
	
	default boolean isNew() {
		return getId() == null;
	}
	
}
