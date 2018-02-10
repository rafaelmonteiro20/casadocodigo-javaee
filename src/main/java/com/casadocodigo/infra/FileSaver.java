package com.casadocodigo.infra;

import javax.servlet.http.Part;

public interface FileSaver {

	String write(String baseFolder, Part multipartFile);
	
}
