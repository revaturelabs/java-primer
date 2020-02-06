package com.revature.collections;

public class IceCream implements Comparable<IceCream> {
	private String flavor;
	private String brand;
	private int calories;
	
	public IceCream() {}
	
	public IceCream(String flavor, String brand, int calories) {
		this.flavor = flavor;
		this.brand = brand;
		this.calories = calories;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + calories;
		result = prime * result + ((flavor == null) ? 0 : flavor.hashCode());
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
		IceCream other = (IceCream) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (calories != other.calories)
			return false;
		if (flavor == null) {
			if (other.flavor != null)
				return false;
		} else if (!flavor.equals(other.flavor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "IceCream [flavor=" + flavor + ", brand=" + brand + ", calories=" + calories + "]";
	}

	//The natural order of IceCream is: flavor
	@Override
	public int compareTo(IceCream o) {
		/**
		 * Ascending
		 */
		//return this.flavor.compareTo(o.flavor);
		
		/**
		 * Descending
		 */
		return o.flavor.compareTo(this.flavor);
	}
}
