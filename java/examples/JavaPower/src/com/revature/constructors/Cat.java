package com.revature.constructors;

public class Cat extends Animal {
	private int numberOfLives;
	private String fur;
	
	public Cat() {
		//super(); // ON OR THE OTHER
		this(9, "gray");
		System.out.println("no args Cat");
	}

	public Cat(int numberOfLives, String fur) {
		//this(); // Someone needs to call super
		this.numberOfLives = numberOfLives;
		this.fur = fur;
		System.out.println("Cat with arguments");
	}

	public int getNumberOfLives() {
		return numberOfLives;
	}

	public void setNumberOfLives(int numberOfLives) {
		this.numberOfLives = numberOfLives;
	}

	public String getFur() {
		return fur;
	}

	public void setFur(String fur) {
		this.fur = fur;
	}
	
	/**
	 * If o1.hashCode() != o2.hashCode(), equals must not return true
	 * Else, we need to check equals because it might not be true.\
	 * 
	 * You lose a step, if o1.hashCode() == o2.hashCode() doesn't return false.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fur == null) ? 0 : fur.hashCode());
		result = prime * result + numberOfLives;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cat other = (Cat) obj;
		if (fur == null) {
			if (other.fur != null)
				return false;
		} else if (!fur.equals(other.fur))
			return false;
		if (numberOfLives != other.numberOfLives)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cat [numberOfLives=" + numberOfLives + ", fur=" + fur + "]";
	}
	
	public static void main(String[] args) {
		Cat c1 = new Cat();
		Cat c2 = new Cat();
		System.out.println(c1.equals(c2)); //TRUE!
		System.out.println(c1 == c2); //FALSE 
		System.out.println(c1.hashCode() == c2.hashCode());
		
	}
}
