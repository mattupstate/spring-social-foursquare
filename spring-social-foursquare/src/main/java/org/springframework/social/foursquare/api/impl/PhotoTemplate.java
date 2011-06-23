package org.springframework.social.foursquare.api.impl;

import org.springframework.core.io.Resource;
import org.springframework.social.foursquare.api.Photo;
import org.springframework.social.foursquare.api.PhotoOperations;
import org.springframework.social.foursquare.api.impl.json.PhotoContainer;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class PhotoTemplate extends AbstractFoursquareOperations implements PhotoOperations {

	public PhotoTemplate(FoursquareTemplate foursquare, boolean isAuthorized) {
		super(foursquare, isAuthorized);
	}
	
	public Photo get(String photoId) {
		requireUserAuthorization();
		return get(buildUri(PHOTOS_ENDPOINT + photoId), PhotoContainer.class).getPhoto();
	}

	public Photo addToCheckin(String checkinId, Resource photo, String broadcast, Double latitude, Double longitude, Long locationAccuracy, Double altitude, Long altitudeAccuracy) {
		requireUserAuthorization();
		return post(buildUri(PHOTOS_ENDPOINT + "add"), createPhotoParams("checkinId", checkinId, photo, broadcast, latitude, longitude, locationAccuracy, altitude, altitudeAccuracy), PhotoContainer.class).getPhoto();
	}

	public Photo addToTip(String tipId, Resource photo, String broadcast, Double latitude, Double longitude, Long locationAccuracy, Double altitude, Long altitudeAccuracy) {
		requireUserAuthorization();
		return post(buildUri(PHOTOS_ENDPOINT + "add"), createPhotoParams("checkinId", tipId, photo, broadcast, latitude, longitude, locationAccuracy, altitude, altitudeAccuracy), PhotoContainer.class).getPhoto();
	}

	public Photo addToVenue(String venueId, Resource photo, String broadcast, Double latitude, Double longitude, Long locationAccuracy, Double altitude, Long altitudeAccuracy) {
		requireUserAuthorization();
		return post(buildUri(PHOTOS_ENDPOINT + "add"), createPhotoParams("checkinId", venueId, photo, broadcast, latitude, longitude, locationAccuracy, altitude, altitudeAccuracy), PhotoContainer.class).getPhoto();
	}

	private MultiValueMap<String,Object> createPhotoParams(String entityParameter, String entityValue, Resource photo, String broadcast, Double latitude, Double longitude, Long locationAccuracy, Double altitude, Long altitudeAccuracy) {
		MultiValueMap<String,Object> params = new LinkedMultiValueMap<String, Object>();
		params.add(entityParameter, entityValue);
		params.add("photo", photo);
		if(latitude != null && longitude != null) {
			params.add("ll", latitude.toString() + "," + longitude.toString());
		}
		if(locationAccuracy != null) {
			params.add("llAcc", locationAccuracy.toString());
		}
		if(broadcast != null) {
			params.add("broadcast", broadcast);
		}
		if(altitude != null) {
			params.add("alt", locationAccuracy.toString());
		}
		if(altitudeAccuracy != null) {
			params.add("altAcc", altitudeAccuracy.toString());
		}
		return params;
	}
}
