package org.springframework.social.foursquare.api.impl;

import org.springframework.social.foursquare.api.Venue;
import org.springframework.social.foursquare.api.VenueOperations;
import org.springframework.social.foursquare.api.impl.json.VenueContainer;

public class VenueTemplate extends AbstractFoursquareOperations implements VenueOperations {

	public VenueTemplate(FoursquareTemplate foursquare, boolean isAuthorized) {
		super(foursquare, isAuthorized);
	}

	public Venue getVenue(String venueId) {
		return get(buildUri(VENUES_ENDPOINT + venueId + "/"), VenueContainer.class).getVenue();
	}

}
