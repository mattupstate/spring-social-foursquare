package org.springframework.social.foursquare.api;

import java.util.List;

public class Photos {
	
	private int count;
	private List<PhotoGroup> groups;
	
	public Photos(int count, List<PhotoGroup> groups) {
		this.count = count;
		this.groups = groups;
	}

	public int getCount() {
		return count;
	}

	public List<PhotoGroup> getGroups() {
		return groups;
	}
	
}
