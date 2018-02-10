package com.casadocodigo.infra;

import java.io.IOException;
import java.nio.file.Path;

import javax.enterprise.context.ApplicationScoped;
import javax.servlet.http.Part;


@ApplicationScoped
public class FileSaverLocal implements FileSaver {
	
	private static final String CONTENT_DISPOSITION = "content-disposition";

	private static final String FILENAME_KEY = "filename=";
	
	private Path local;
	
	
	public FileSaverLocal(Path local) {
		this.local = local;
	}
	
	@Override
	public String write(String baseFolder, Part multipartFile) {
		
		String fileName = extractFileName(multipartFile.getHeader(CONTENT_DISPOSITION));
		
		try {
			multipartFile.write(createPath(baseFolder, fileName));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		return baseFolder + "/" + fileName;
	}

	private String createPath(String baseFolder, String fileName) {
		return this.local.toAbsolutePath().toString() + "/" + baseFolder + "/" + fileName;
	}
	
	private String extractFileName(String contentDisposition) {
		if (contentDisposition == null) {
			return null;
		}
		
		int startIndex = contentDisposition.indexOf(FILENAME_KEY);
		if (startIndex == -1) {
			return null;
		}
		
		String filename = contentDisposition.substring(startIndex + FILENAME_KEY.length());
		if (filename.startsWith("\"")) {
			int endIndex = filename.indexOf("\"", 1);
			if (endIndex != -1) {
				return filename.substring(1, endIndex);
			}
		} else {
			int endIndex = filename.indexOf(";");
			if (endIndex != -1) {
				return filename.substring(0, endIndex);
			}
		}
		
		return filename;
	}

}
