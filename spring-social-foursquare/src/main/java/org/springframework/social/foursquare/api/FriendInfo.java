package org.springframework.social.foursquare.api;

import java.util.List;

public class FriendInfo {
	
	private int total;
	private List<FriendGroup> groups;
	
	public FriendInfo(int total, List<FriendGroup> groups) {
		this.total = total;
		this.groups = groups;
	}

	public int getTotal() {
		return total;
	}

	public List<FriendGroup> getGroups() {
		return groups;
	}
}
