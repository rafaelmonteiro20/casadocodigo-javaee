package com.casadocodigo.storage;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Path;

import javax.servlet.http.Part;

public interface FileSaver {

	public String write(String baseFolder, Part multipartFile);
	
	public static void transfer(Path source, OutputStream output) {
		try {
			FileInputStream input = new FileInputStream(source.toFile());
			
			try(ReadableByteChannel inputChannel = Channels.newChannel(input);
				WritableByteChannel outputChannel = Channels.newChannel(output)) {
				
				ByteBuffer buffer = ByteBuffer.allocateDirect(1024 * 10);
				while(inputChannel.read(buffer) != -1) {
					buffer.flip();
					outputChannel.write(buffer);
					buffer.clear();
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
