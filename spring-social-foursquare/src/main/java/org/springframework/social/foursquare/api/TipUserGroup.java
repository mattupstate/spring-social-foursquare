package org.springframework.social.foursquare.api;

import java.util.List;

public class TipUserGroup {
	
	private String type;
	private String name;
	private int count;
	private List<FoursquareUser> items;
	
	public TipUserGroup(String type, String name, int count, List<FoursquareUser> items) {
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

	public List<FoursquareUser> getItems() {
		return items;
	}
}
