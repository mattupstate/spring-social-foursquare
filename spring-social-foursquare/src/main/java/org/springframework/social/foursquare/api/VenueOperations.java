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
	
	/**
	 * Retrieve a list of recommended venues near the current location. 
	 * @return	An explore response
	 */
	ExploreResponse explore(ExploreQuery query);
	
	/**
	 * Search Foursquare venues
	 * @param query	A VenueSearchQuery object
	 * @return	A list of venues
	 */
	List<Venue> search(VenueSearchQuery query);
	
	/**
	 * Retreive a list of venues near the specified location with the most people currently checked in. 
	 * @param latitude	Latitude
	 * @param longitude	Longitude
	 * @param radius	Radius
	 * @param limit	Limit
	 * @return	A list of venues
	 */
	List<Venue> getTrending(double latitude, double longitude, int radius, int limit);
	
	/**
	 * Retrieve a count of how many people are at a given venue.
	 * @param venueId	A Foursquare venue ID
	 * @param afterTimestamp Seconds since epoch
	 * @param offset Offset 
	 * @param limit
	 * @return
	 */
	CheckinInfo getHereNow(String venueId, long afterTimestamp, int offset, int limit);
	
	/**
	 * Retrieve the tips for the specified venue
	 * @param venueId A Foursquare venue ID
	 * @param sort Sort. Either 'recent' or 'popular'
	 * @param offset Result set offset
	 * @param limit	Result set limit
	 * @return	Tips object
	 */
	Tips getTips(String venueId, String sort, int offset, int limit);
	
	/**
	 * Retrieve photos for the specified venue
	 * @param venueId A Foursquare venue ID
	 * @param group	Group. Either 'checkin' or 'venue'
	 * @param offset Result set offset
	 * @param limit	Result set limit
	 * @return	VenuePhotos
	 */
	VenuePhotos getPhotos(String venueId, String group, int offset, int limit);
	
	public static final String VENUES_ENDPOINT = "venues/";
}
