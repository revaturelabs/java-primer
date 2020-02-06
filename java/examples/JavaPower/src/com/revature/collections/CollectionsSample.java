package com.revature.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CollectionsSample {
	
	public void listSample(IceCream... creams) {
		List<IceCream> list = new ArrayList<>();
		
		for(IceCream i: creams) {
			list.add(i);
		}
		
		//Extra
		List<IceCream> differentWay = Arrays.asList(creams);
		//End extra
		
		System.out.println("Regular for loop List");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("Enhanced for loop List");
		for(IceCream i: creams) {
			System.out.println(i);
		}
		
		System.out.println("Iterator");
		Iterator<IceCream> i = list.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}
	
	public void hashSetSample(IceCream... creams) {
		Set<IceCream> set = new HashSet<IceCream>();
		
		for(IceCream i: creams) {
			set.add(i);
		}
		
		System.out.println("HashSet");
		
		/**
		 * Not that order is not guaranteed in this case,
		 * and to guarantee uniqueness, the POJO must override
		 * hashCode and equals (BOTH!).
		 * 
		 * Remember: == -> hashCode() -> equals()
		 */
		for(IceCream i: set) {
			System.out.println(i);
		}
	}
	
	public Set<IceCream> sorting(IceCream... creams) {
		Set<IceCream> set = new TreeSet<>();
		
		for(IceCream i: creams) {
			set.add(i);
		}
		
		return set;
	}
	
	public Set<IceCream> sortingComparator(IceCream... creams) {
		//Set<IceCream> set = new TreeSet<>(new BrandComparator());
		
		Set<IceCream> set = new TreeSet<>((IceCream i1, IceCream i2) -> {
			return i1.getBrand().compareTo(i2.getBrand());
		});
		
		for(IceCream i: creams) {
			set.add(i);
		}
		
		return set;
	}
	
	public static void main(String[] args) {
		IceCream[] creams = {
				new IceCream("Chocolate", "Magnum", 200),
				new IceCream("Chocolate", "Ben & Jerry's", 200),
				new IceCream("Vanilla", "Hagen Daas", 150),
				new IceCream("Strawberry", "Turkey Hill", 100),
				new IceCream("Strawberry", "Turkey Hill", 100),
				new IceCream("Strawberry", "Turkey Hill", 100),
				new IceCream("Strawberry", "Turkey Hill", 100),
				new IceCream("Strawberry", "Turkey Hill", 100),
				new IceCream("Strawberry", "Turkey Hill", 100),
				new IceCream("Strawberry", "Turkey Hill", 100)
				};
		new CollectionsSample().listSample(creams);
		new CollectionsSample().hashSetSample(creams);
		
		/**
		 * Not that even without hashCode and equals, sorted sets
		 * will remove duplicate elements depending on what attribute
		 * you are sorting (We have 3 unique flavors, and 4 unique brands).
		 */
		System.out.println("Sorting:");
		System.out.println(new CollectionsSample().sorting(creams));
		System.out.println("Sorting Comparator:");
		System.out.println(new CollectionsSample().sortingComparator(creams));
		//comment hashCode()
	}
}
