package org.springframework.social.foursquare.api;

public interface UserOperations {

	FoursquareUser getUser();
	
	Leaderboard getLeaderboard();
	
	public static final String USERS_ENDPOINT = "users/";
}
