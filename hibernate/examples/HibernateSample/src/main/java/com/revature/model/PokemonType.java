package com.revature.model;

import java.io.Serializable;

/*
 * A bean must implement Serializable, Comparable
 * and override hashCode() and equals().
 */
public class PokemonType implements Serializable {
	/**
	 * Compatibility with Java 2.x 
	 */
	private static final long serialVersionUID = -2783359867056908045L;
	
	private int id;
	private String element;
	
	public PokemonType() {}

	public PokemonType(String element) {
		this.element = element;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	@Override
	public String toString() {
		return "PokemonType [id=" + id + ", element=" + element + "]";
	}
}
