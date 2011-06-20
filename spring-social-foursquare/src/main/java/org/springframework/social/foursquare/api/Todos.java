package org.springframework.social.foursquare.api;

import java.util.List;

public class Todos {
	
	private int count;
	private List<Todo> items;
	
	public Todos(int count, List<Todo> items) {
		this.count = count;
		this.items = items;
	}

	public int getCount() {
		return count;
	}

	public List<Todo> getItems() {
		return items;
	}
	
	
}
