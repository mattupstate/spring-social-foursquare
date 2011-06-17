package org.springframework.social.foursquare.api;

public class VenueStats {
	
	private int checkinsCount;
	private int usersCount;
	
	public VenueStats(int checkinsCount, int usersCount) {
		this.checkinsCount = checkinsCount;
		this.usersCount = usersCount;
	}

	public int getCheckinsCount() {
		return checkinsCount;
	}

	public void setCheckinsCount(int checkinsCount) {
		this.checkinsCount = checkinsCount;
	}

	public int getUsersCount() {
		return usersCount;
	}

	public void setUsersCount(int usersCount) {
		this.usersCount = usersCount;
	}
	
}
