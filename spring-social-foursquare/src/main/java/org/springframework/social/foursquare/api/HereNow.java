package org.springframework.social.foursquare.api;

import java.util.List;

public class HereNow {
	
	private int count;
	private List<FoursquareUserGroup> groups;
	
	public HereNow(int count, List<FoursquareUserGroup> groups) {
		this.count = count;
		this.groups = groups;
	}

	public int getCount() {
		return count;
	}

	public List<FoursquareUserGroup> getGroups() {
		return groups;
	}
	
}
