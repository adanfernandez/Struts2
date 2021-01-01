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
}
