package com.casadocodigo.storage;

import java.nio.file.Paths;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class FileSaverProducer {

	public static final String SERVER_PATH = "c:/casadocodigo";
	
	@Produces
	public FileSaver createFileSaver() {
		return new FileSaverLocal(Paths.get(SERVER_PATH));
	}
	
}
