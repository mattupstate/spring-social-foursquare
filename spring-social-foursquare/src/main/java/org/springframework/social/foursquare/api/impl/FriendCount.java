package org.springframework.social.foursquare.api.impl;

import org.codehaus.jackson.annotate.JsonProperty;

public class FriendCount {
	
	private int count;
	
	public FriendCount(@JsonProperty("count") int count) {
		this.count = count;
	}
	
	public int getCount() {
		return count;
	}
}
