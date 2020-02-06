//import java.util.List; // -> this will break the class.
//package must be the first line.

package com.revature.imports;

import java.util.List;
import java.util.*; //Bad practice

import static java.lang.Integer.MAX_VALUE;

public class Importing {
	List<?> l;
	AbstractList<?> a;
	int i = MAX_VALUE;
	float f = Float.MAX_VALUE; //I don't want to do this.
}
