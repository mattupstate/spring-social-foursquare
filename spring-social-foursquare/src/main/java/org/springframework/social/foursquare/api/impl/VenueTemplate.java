package org.springframework.social.foursquare.api.impl;

import org.springframework.social.foursquare.api.Venue;
import org.springframework.social.foursquare.api.VenueOperations;
import org.springframework.social.foursquare.api.impl.json.VenueContainer;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class VenueTemplate extends AbstractFoursquareOperations implements VenueOperations {

	public VenueTemplate(FoursquareTemplate foursquare, boolean isAuthorized) {
		super(foursquare, isAuthorized);
	}

	public Venue getVenue(String venueId) {
		return get(buildUri(VENUES_ENDPOINT + venueId + "/"), VenueContainer.class).getVenue();
	}

	public Venue addVenue(String name, String address, String crossStreet, String city, String state, 
			String zip, String phone, double latitude, double longitude, String primaryCategoryId) {
		requireUserAuthorization();
		MultiValueMap<String,String> params = new LinkedMultiValueMap<String, String>();
		params.add("name", name);
		params.add("address", address);
		params.add("crossStreet", crossStreet);
		params.add("city", city);
		params.add("state", state);
		params.add("zip", zip);
		params.add("phone", phone);
		params.add("ll", Double.toString(latitude) + "," + Double.toString(longitude));
		params.add("primaryCategoryId", primaryCategoryId);
		return post(buildUri(VENUES_ENDPOINT + "add/"), params, VenueContainer.class).getVenue();
	}

}
