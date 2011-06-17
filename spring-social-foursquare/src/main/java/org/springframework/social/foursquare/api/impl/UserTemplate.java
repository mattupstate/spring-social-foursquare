package org.springframework.social.foursquare.api.impl;

import org.springframework.social.foursquare.api.FoursquareUser;
import org.springframework.social.foursquare.api.UserOperations;
import org.springframework.social.foursquare.api.impl.json.FoursquareUserContainer;

public class UserTemplate extends AbstractFoursquareOperations implements UserOperations {
	
	public UserTemplate(FoursquareTemplate foursquare, boolean isAuthorized) {
		super(foursquare, isAuthorized);
	}
	
	public FoursquareUser getUser() {
		requireUserAuthorization();
		return get(buildUri(USERS_ENDPOINT + "self/"), FoursquareUserContainer.class).getUser();
	}

}
