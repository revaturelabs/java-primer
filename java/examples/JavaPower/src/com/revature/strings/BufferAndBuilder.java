package com.revature.strings;

public class BufferAndBuilder {
	public void playingWithBuilder(String s) {
		StringBuilder builder = new StringBuilder(s);
		
		builder.append("a");
		builder.append("J");
		builder.reverse();
		
		System.out.println(builder);
		
		builder = new StringBuilder(s);
		//StringBuilder or Buffer return itself so you can chain its methods.
		System.out.println(builder.append("a").append("J").reverse());
	}
	
	public static void main(String[] args) {
		new BufferAndBuilder().playingWithBuilder("av");
	}
}
