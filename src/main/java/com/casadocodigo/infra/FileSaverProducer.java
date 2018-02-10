package com.casadocodigo.infra;

import java.nio.file.Paths;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class FileSaverProducer {

	@Produces
	public FileSaver createFileSaver() {
		return new FileSaverLocal(Paths.get("c:/casadocodigo"));
	}
	
}
