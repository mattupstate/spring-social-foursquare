package org.springframework.social.foursquare.api;

import java.util.List;

public class PhotoGroup {
	
	private String type;
	private String name;
	private int count;
	private List<Photo> items;
	
	public PhotoGroup(String type, String name, int count, List<Photo> items) {
		this.type = type;
		this.name = name;
		this.count = count;
		this.items = items;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public int getCount() {
		return count;
	}

	public List<Photo> getItems() {
		return items;
	}
	
	
}
