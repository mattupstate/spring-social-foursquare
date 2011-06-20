package org.springframework.social.foursquare.api;

import java.util.List;

public class Friends {
	
	private int count;
	private List<FoursquareUser> items;
	
	public Friends(int count, List<FoursquareUser> items) {
		this.count = count;
		this.items = items;
	}

	public int getCount() {
		return count;
	}

	public List<FoursquareUser> getItems() {
		return items;
	}
	
}
