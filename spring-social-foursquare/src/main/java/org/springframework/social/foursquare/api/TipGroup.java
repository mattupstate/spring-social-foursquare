package org.springframework.social.foursquare.api;

import java.util.List;

public class TipGroup {
	
	private String type;
	private String name;
	private int count;
	private List<Tip> items;
	
	public TipGroup(String type, String name, int count, List<Tip> items) {
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

	public List<Tip> getItems() {
		return items;
	}
	
}
