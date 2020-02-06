package com.revature.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.apache.log4j.Logger;

public class FileManipulationBuffer<T extends CharSequence> implements FileManipulation<T> {

	private static Logger logger = Logger.getLogger(FileManipulationBuffer.class);
	
	@SuppressWarnings("unchecked")
	public T read(String filePath) throws IOException {
		//We get the current time
		long startTime = System.currentTimeMillis();

		//We open the buffered reader
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		
		//We read the content (bulks of characters behind the scenes)
		StringBuilder content = new StringBuilder();
		while(reader.ready()) {
			content.append(reader.readLine());
		}
		
		logger.info("Bulks Read: ("+ (System.currentTimeMillis() - startTime) +"ms)");
		//We close the resources
		reader.close();
		//Because T can only be a CharSequence
		return (T) content;
	}

	public void write(String filePath, T content) {
		try(Writer writer = new BufferedWriter(new FileWriter(filePath))) {
			writer.write(content.toString());
		} catch (IOException e) {
			System.out.println(e);
		} 
	}
}
