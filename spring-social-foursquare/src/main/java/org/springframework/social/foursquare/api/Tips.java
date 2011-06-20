package org.springframework.social.foursquare.api;

import java.util.List;

public class Tips {
	private int count;
	private List<Tip> items;
	
	public Tips(int count, List<Tip> items) {
		this.count = count;
		this.items = items;
	}

	public int getCount() {
		return count;
	}

	public List<Tip> getItems() {
		return items;
	}
}
