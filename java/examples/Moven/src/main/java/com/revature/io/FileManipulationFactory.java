package com.revature.io;

/**
 * File manipulation factory of characters structures.
 */
public class FileManipulationFactory {
	public static enum FileManipulationType {
		BUFFER,
		SERIALIZABLE
	}
	
	private FileManipulationFactory() {}

	private static FileManipulationFactory factory = new FileManipulationFactory();
	
	public static FileManipulationFactory getFactory() {
		return factory;
	}
	
	//End Singleton Logic
	
	public FileManipulation<CharSequence> getInstance(FileManipulationType name) throws IllegalArgumentException {
		switch(name) {
		case SERIALIZABLE:
			return new FileManipulationSerializable<>();
		case BUFFER:
			return new FileManipulationBuffer<>();
		default:
			throw new IllegalArgumentException("Unsupported file manipulation type.");
		}
	}
}
