package org.springframework.social.foursquare.api;

import org.springframework.core.io.Resource;

public interface PhotoOperations {
	
	/**
	 * Get details of a photo.
	 * @param photoId	Photo ID
	 * @return	a photo
	 */
	Photo get(String photoId);
	
	Photo addToCheckin(String checkinId, Resource photo, Double latitude, String broadcast, Double longitude, Long locationAccuracy, Double altitude, Long altitudeAccuracy);
	
	Photo addToTip(String tipId, Resource photo, Double latitude, String broadcast, Double longitude, Long locationAccuracy, Double altitude, Long altitudeAccuracy);
	
	Photo addToVenue(String venueId, Resource photo, Double latitude, String broadcast, Double longitude, Long locationAccuracy, Double altitude, Long altitudeAccuracy);
	
	public static final String PHOTOS_ENDPOINT = "photos/";
}
