package org.springframework.social.foursquare.api;

import java.util.List;

public class PhotoSizes {
	
	private int count;
	private List<PhotoSize> items;
	
	public PhotoSizes(int count, List<PhotoSize> items) {
		this.count = count;
		this.items = items;
	}

	public int getCount() {
		return count;
	}

	public List<PhotoSize> getItems() {
		return items;
	}
	
}
