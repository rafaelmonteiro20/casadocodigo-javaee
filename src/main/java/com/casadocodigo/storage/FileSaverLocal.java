package com.casadocodigo.storage;

import java.io.IOException;
import java.nio.file.Path;

import javax.enterprise.context.ApplicationScoped;
import javax.servlet.http.Part;

@ApplicationScoped
public class FileSaverLocal implements FileSaver {
	
	private Path local;
	
	public FileSaverLocal(Path local) {
		this.local = local;
	}
	
	@Override
	public String write(String baseFolder, Part file) {
		
		String relative = baseFolder + "/" + file.getSubmittedFileName();
		String fullPath = local + "/" + relative;
		
		try {
			file.write(fullPath);
			return relative;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
