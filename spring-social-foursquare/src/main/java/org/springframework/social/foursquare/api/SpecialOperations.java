package org.springframework.social.foursquare.api;


public interface SpecialOperations {
	
	/**
	 * Retrieve details of a special
	 * @param specialId	Special ID
	 * @param venueId	Venue ID
	 * @return	Special
	 */
	Special get(String specialId, String venueId);
	
	/**
	 * Search for specials near the specified location
	 * @param latitude	Latitude
	 * @param longitude	Longitude
	 * @param locationAccuracy	Location accuracy in meters
	 * @param altitude	Altitude in meters
	 * @param altitudeAccuracy	Altitude accuracy in meters
	 * @param limit	Result set limit
	 * @return	A list of specials
	 */
	Specials search(Double latitude, Double longitude, Long locationAccuracy, Double altitude, Long altitudeAccuracy, Integer limit);
	
	public static final String SPECIALS_ENDPOINT = "specials/";
	
}
