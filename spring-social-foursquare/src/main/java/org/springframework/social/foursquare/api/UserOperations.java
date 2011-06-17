package org.springframework.social.foursquare.api;

public interface UserOperations {

	FoursquareUser getUser();
	
	public static final String USERS_ENDPOINT = "users/";
}
