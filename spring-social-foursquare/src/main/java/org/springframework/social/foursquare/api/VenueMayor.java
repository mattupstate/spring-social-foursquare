package org.springframework.social.foursquare.api;

public class VenueMayor {
	
	private int count;
	private FoursquareUser user;
	
	public VenueMayor(int count, FoursquareUser user) {
		this.count = count;
		this.user = user;
	}

	public int getCount() {
		return count;
	}

	public FoursquareUser getUser() {
		return user;
	}
	
}
