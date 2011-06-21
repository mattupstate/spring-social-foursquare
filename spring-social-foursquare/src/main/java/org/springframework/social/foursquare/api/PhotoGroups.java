package org.springframework.social.foursquare.api;

import java.util.List;

public class PhotoGroups {
	
	private int count;
	private List<PhotoGroup> groups;
	
	public PhotoGroups(int count, List<PhotoGroup> groups) {
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
