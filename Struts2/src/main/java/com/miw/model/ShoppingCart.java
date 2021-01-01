package com.miw.model;

import java.util.HashMap;

public class ShoppingCart {
	private HashMap<String, Integer> books;
	
	public ShoppingCart() {
		books = new HashMap<String, Integer>();
	}
	
	public HashMap<String, Integer> getBooks() {
		return books;
	}
	
	public void add(String book) {
		Integer numero = books.get(book);
		if (numero == null) {
			books.put(book, 1);
		} else { 
			books.put(book, ++numero);
		}
	}
}
