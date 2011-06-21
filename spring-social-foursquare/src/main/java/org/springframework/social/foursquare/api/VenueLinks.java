package org.springframework.social.foursquare.api;

import java.util.List;

public class VenueLinks {
	private int count;
	private List<VenueLink> items;
	
	public VenueLinks(int count, List<VenueLink> items) {
		this.count = count;
		this.items = items;
	}

	public int getCount() {
		return count;
	}

	public List<VenueLink> getItems() {
		return items;
	}
}
