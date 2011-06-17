package org.springframework.social.foursquare.api;

import java.util.List;

public class FriendGroup {
	
	private String type;
	private String name;
	private List<FoursquareUser> friends;
	
	public FriendGroup(String type, String name, List<FoursquareUser> friends) {
		this.type = type;
		this.name = name;
		this.friends = friends;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public List<FoursquareUser> getFriends() {
		return friends;
	}

}
