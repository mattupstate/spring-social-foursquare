package org.springframework.social.foursquare.api.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.social.foursquare.api.Special;
import org.springframework.social.foursquare.api.SpecialOperations;
import org.springframework.social.foursquare.api.Specials;
import org.springframework.social.foursquare.api.impl.json.SpecialContainer;
import org.springframework.social.foursquare.api.impl.json.SpecialsContainer;

public class SpecialTemplate extends AbstractFoursquareOperations implements SpecialOperations {

	public SpecialTemplate(FoursquareTemplate foursquare, boolean isAuthorized) {
		super(foursquare, isAuthorized);
	}
	
	public Special get(String specialId, String venueId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("venueId", venueId);
		return get(buildUri(SPECIALS_ENDPOINT + specialId, params), SpecialContainer.class).getSpecial();
	}

	public Specials search(Double latitude, Double longitude, Long locationAccuracy, Double altitude, Long altitudeAccuracy, Integer limit) {
		Map<String, String> params = new HashMap<String, String>();
		if(latitude != null && longitude != null) {
			params.put("ll", latitude.toString() + "," + longitude.toString());
		}
		if(locationAccuracy != null) {
			params.put("llAcc", locationAccuracy.toString());
		}
		if(altitude != null) {
			params.put("alt", altitude.toString());
		}
		if(altitudeAccuracy != null) {
			params.put("altAcc", altitudeAccuracy.toString());
		}
		if(limit != null) {
			params.put("limit", limit.toString());
		}
		return get(buildUri(SPECIALS_ENDPOINT + "search", params), SpecialsContainer.class).getSpecials();
	}
	
}
