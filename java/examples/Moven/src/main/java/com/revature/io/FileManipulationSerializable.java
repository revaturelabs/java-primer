package com.revature.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileManipulationSerializable<T> implements FileManipulation<T> {
	
	public T read(String filePath) throws IOException, ClassNotFoundException {
		ObjectInputStream input = new ObjectInputStream(new FileInputStream(filePath));
		
		@SuppressWarnings("unchecked")
		T objects = (T) input.readObject();
		input.close();
		return objects;
	}

	public void write(String filePath, T content) throws IOException {
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filePath));
		output.writeObject(content);
		output.close();
	}
}
