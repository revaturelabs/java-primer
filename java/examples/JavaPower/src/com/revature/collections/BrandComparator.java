package com.revature.collections;

import java.util.Comparator;

public class BrandComparator implements Comparator<IceCream> {

	@Override
	public int compare(IceCream o1, IceCream o2) {
		return o1.getBrand().compareTo(o2.getBrand());
	}
	
}
