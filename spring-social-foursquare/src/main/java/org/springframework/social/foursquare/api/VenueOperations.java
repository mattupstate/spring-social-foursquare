package org.springframework.social.foursquare.api;

public interface VenueOperations {
	
	Venue getVenue(String venueId);
	
	Venue addVenue(String name, String address, String crossStreet, String city, String state, 
			String zip, String phone, double latitude, double longitude, String primaryCategoryId);
	
	public static final String VENUES_ENDPOINT = "venues/";
}
