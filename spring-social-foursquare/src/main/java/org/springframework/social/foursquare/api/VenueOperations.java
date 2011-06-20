package org.springframework.social.foursquare.api;

public interface VenueOperations {
	
	/**
	 * Retrieve the specified venue
	 * @param venueId	A Foursquare venue ID
	 * @return	Venue
	 */
	Venue getVenue(String venueId);
	
	/**
	 * Add a venue to Foursquare. All fields are optional, but one of either a valid address 
	 * or a geolat/geolong pair must be provided. It's reecommended that geolat/geolong pair 
	 * is provided in every case. 
	 * @param name Name
	 * @param address	Address	
	 * @param crossStreet	Cross street
	 * @param city	City
	 * @param state	State/Province
	 * @param zip	Zip/Postal code
	 * @param phone	Phone
	 * @param latitude	Latitude
	 * @param longitude	Longitude
	 * @param primaryCategoryId	Foursquare venue category ID
	 * @return	Created Venue object
	 */
	Venue addVenue(String name, String address, String crossStreet, String city, String state, 
			String zip, String phone, double latitude, double longitude, String primaryCategoryId);
	
	public static final String VENUES_ENDPOINT = "venues/";
}
