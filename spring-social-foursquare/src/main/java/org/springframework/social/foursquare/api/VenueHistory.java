package org.springframework.social.foursquare.api;

import java.util.List;

public class VenueHistory {
	private int count;
	private List<VenueHistoryItem> items;
	
	public VenueHistory(int count, List<VenueHistoryItem> items) {
		this.count = count;
		this.items = items;
	}

	public int getCount() {
		return count;
	}

	public List<VenueHistoryItem> getItems() {
		return items;
	}
	
}
