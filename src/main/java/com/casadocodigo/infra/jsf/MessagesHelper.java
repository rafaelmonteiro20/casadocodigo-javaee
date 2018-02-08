package com.casadocodigo.infra.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

public class MessagesHelper {

	@Inject
	private FacesContext context;

	@Inject
	private ExternalContext external;
	
	
	public void addFlash(String message) {
		context.addMessage(null, new FacesMessage(message));
		external.getFlash().setKeepMessages(true);
	}
	
}
