package org.springframework.social.foursquare.api;

import java.util.List;

public interface VenueOperations {
	
	/**
	 * Retrieve the specified venue
	 * @see https://developer.foursquare.com/docs/venues/venues.html
	 * @param venueId	A Foursquare venue ID
	 * @return	Venue
	 */
	Venue getVenue(String venueId);
	
	/**
	 * Add a venue to Foursquare. All fields are optional, but one of either a valid address 
	 * or a geolat/geolong pair must be provided. It's reecommended that geolat/geolong pair 
	 * is provided in every case. 
	 * @see https://developer.foursquare.com/docs/venues/add.html
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
	
	/**
	 * Retrieves a hierarchical list of categories applied to venues.
	 * @see https://developer.foursquare.com/docs/venues/categories.html
	 * @return A hierarchical list of categories
	 */
	List<Category> getCategories();
	
	public static final String VENUES_ENDPOINT = "venues/";
}
