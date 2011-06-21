package org.springframework.social.foursquare.api;

import java.util.List;

public class Photos {
	
	private int count;
	private List<Photo> items;
	
	public Photos(int count, List<Photo> items) {
		this.count = count;
		this.items = items;
	}

	public int getCount() {
		return count;
	}

	public List<Photo> getItems() {
		return items;
	}
}
