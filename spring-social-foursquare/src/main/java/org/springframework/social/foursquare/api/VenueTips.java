package org.springframework.social.foursquare.api;

import java.util.List;

public class VenueTips {
	
	private int count;
	private List<TipGroup> groups;
	
	public VenueTips(int count, List<TipGroup> groups) {
		this.count = count;
		this.groups = groups;
	}

	public int getCount() {
		return count;
	}

	public List<TipGroup> getGroups() {
		return groups;
	}
	
}
