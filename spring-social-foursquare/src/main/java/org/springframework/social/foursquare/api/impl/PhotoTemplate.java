package org.springframework.social.foursquare.api.impl;

import org.springframework.core.io.Resource;
import org.springframework.social.foursquare.api.Photo;
import org.springframework.social.foursquare.api.PhotoOperations;
import org.springframework.social.foursquare.api.impl.json.PhotoContainer;

public class PhotoTemplate extends AbstractFoursquareOperations implements PhotoOperations {

	public PhotoTemplate(FoursquareTemplate foursquare, boolean isAuthorized) {
		super(foursquare, isAuthorized);
	}
	
	public Photo get(String photoId) {
		requireUserAuthorization();
		return get(buildUri(PHOTOS_ENDPOINT + photoId + "/"), PhotoContainer.class).getPhoto();
	}

	public Photo addToCheckin(String checkinId, Resource photo,
			Double latitude, String broadcast, Double longitude,
			Long locationAccuracy, Double altitude, Long altitudeAccuracy) {
		// TODO Auto-generated method stub
		return null;
	}

	public Photo addToTip(String tipId, Resource photo, Double latitude,
			String broadcast, Double longitude, Long locationAccuracy,
			Double altitude, Long altitudeAccuracy) {
		// TODO Auto-generated method stub
		return null;
	}

	public Photo addToVenue(String venueId, Resource photo, Double latitude,
			String broadcast, Double longitude, Long locationAccuracy,
			Double altitude, Long altitudeAccuracy) {
		// TODO Auto-generated method stub
		return null;
	}

}
