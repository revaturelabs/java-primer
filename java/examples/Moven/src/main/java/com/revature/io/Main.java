package com.revature.io;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.io.FileManipulationFactory.FileManipulationType;

public class Main {

	private static Logger logger = Logger.getLogger(Main.class);
	
	public static void main(String[] args) throws ClassNotFoundException {
		//Writing
		logger.warn(new RuntimeException());

		//BufferedWriter
		FileManipulation<CharSequence> fileManipulation =
				FileManipulationFactory.getFactory().getInstance(FileManipulationType.BUFFER);
		
		Scanner scanner = new Scanner(System.in);
		logger.info("Please write the text you would want to be written: ");
		String input = scanner.nextLine();
		scanner.close();
		
		try {
			fileManipulation.write("src/main/resources/files/buffer.txt",
					new String(input));
		} catch (IOException e) {
			logger.warn(e);
		}

		//BufferedReader
		try {
			logger.info(fileManipulation.read("src/main/resources/files/buffer.txt"));
		} catch (IOException e) {
			logger.warn(e);
		}

		//Serializable
		
		//Writing
		FileManipulation<CharSequence> serializable =
				FileManipulationFactory.getFactory().getInstance(FileManipulationType.SERIALIZABLE);
		try {
			serializable.write("src/main/resources/files/serial.txt", new StringBuffer(input));
			logger.info("Writing Complete");
		} catch (IOException e) {
			logger.warn(e);
		}

		//Reading CharSequence
		try {
			logger.info(serializable.read("src/main/resources/files/serial.txt"));
		} catch (ClassNotFoundException | IOException e) {
			logger.warn(e);
		}
		
		FileManipulation<List<Pojo>> serializablePojos =
				new FileManipulationSerializable<>();
		
		//Writing Pojo List
		try {
			serializablePojos.write("src/main/resources/files/serial-pojo.txt", 
					Arrays.asList(
							new Pojo(1,"peter","1234")));
			logger.info("Writing Pojos Complete");
		} catch (IOException e) {
			logger.warn(e);
		}

		try {
			logger.info(serializable.read("src/main/resources/files/serial-pojo.txt"));
		} catch (ClassNotFoundException | IOException e) {
			logger.warn(e);
		}
	}
}
