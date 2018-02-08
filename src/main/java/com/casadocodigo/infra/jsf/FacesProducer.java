package com.casadocodigo.infra.jsf;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ApplicationScoped
public class FacesProducer {

	@Produces
	@RequestScoped
	public FacesContext getContext() {
		return FacesContext.getCurrentInstance();
	}
	
	@Produces
	@RequestScoped
	public ExternalContext getExternal() {
		return getContext().getExternalContext();
	}
	
}
