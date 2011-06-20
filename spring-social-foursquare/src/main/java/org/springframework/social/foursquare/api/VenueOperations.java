package org.springframework.social.foursquare.api;

public interface VenueOperations {
	
	Venue getVenue(String venueId);
	
	public static final String VENUES_ENDPOINT = "venues/";
}
