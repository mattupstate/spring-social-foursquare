package org.springframework.social.foursquare.api;

import java.util.List;

public class Specials {
	
	private int count;
	private List<Special> items;
	
	public Specials(int count, List<Special> items) {
		this.count = count;
		this.items = items;
	}

	public int getCount() {
		return count;
	}

	public List<Special> getItems() {
		return items;
	}
}
