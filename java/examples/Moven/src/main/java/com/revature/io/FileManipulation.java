package com.revature.io;

import java.io.IOException;

public interface FileManipulation<T> {
	T read(String filePath) throws IOException, ClassNotFoundException;
	void write(String filePath, T content) throws IOException;
}
