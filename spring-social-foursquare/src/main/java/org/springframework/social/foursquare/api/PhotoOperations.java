package org.springframework.social.foursquare.api;

import org.springframework.core.io.Resource;

public interface PhotoOperations {
	
	/**
	 * Get details of a photo.
	 * @param photoId	Photo ID
	 * @return	a photo
	 */
	Photo get(String photoId);
	
	/**
	 * Add a photo to the specified checkin
	 * @param checkinId	Checkin ID
	 * @param photo	Photo resource
	 * @param broadcast	Whether to broadcast this photo either 'twitter', 'facebook', or 'twitter,facebook'
	 * @param latitude	Latitude
	 * @param longitude	Longitude
	 * @param locationAccuracy	Location accuracy in meters
	 * @param altitude	Altitude in meters
	 * @param altitudeAccuracy	Altitude accuracy in meters
	 * @return	The created Photo
	 */
	Photo addToCheckin(String checkinId, Resource photo, String broadcast, Double latitude, Double longitude, Long locationAccuracy, Double altitude, Long altitudeAccuracy);
	
	/**
	 * Add a photo to the specified tip
	 * @param tipId	Tip ID
	 * @param photo	Photo resource
	 * @param broadcast	Whether to broadcast this photo either 'twitter', 'facebook', or 'twitter,facebook'
	 * @param latitude	Latitude
	 * @param longitude	Longitude
	 * @param locationAccuracy	Location accuracy in meters
	 * @param altitude	Altitude in meters
	 * @param altitudeAccuracy	Altitude accuracy in meters
	 * @return	The created Photo
	 */
	Photo addToTip(String tipId, Resource photo, String broadcast, Double latitude, Double longitude, Long locationAccuracy, Double altitude, Long altitudeAccuracy);
	
	/**
	 * Add a photo to the specified venue
	 * @param venueId	Venue ID
	 * @param photo	Photo resource
	 * @param broadcast	Whether to broadcast this photo either 'twitter', 'facebook', or 'twitter,facebook'
	 * @param latitude	Latitude
	 * @param longitude	Longitude
	 * @param locationAccuracy	Location accuracy in meters
	 * @param altitude	Altitude in meters
	 * @param altitudeAccuracy	Altitude accuracy in meters
	 * @return	The created Photo
	 */
	Photo addToVenue(String venueId, Resource photo, String broadcast, Double latitude, Double longitude, Long locationAccuracy, Double altitude, Long altitudeAccuracy);
	
	public static final String PHOTOS_ENDPOINT = "photos/";
}
