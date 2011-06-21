package org.springframework.social.foursquare.api.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.social.foursquare.api.Checkin;
import org.springframework.social.foursquare.api.CheckinOperations;
import org.springframework.social.foursquare.api.CheckinParams;
import org.springframework.social.foursquare.api.impl.json.CheckinContainer;

public class CheckinTemplate extends AbstractFoursquareOperations implements CheckinOperations {

	public CheckinTemplate(FoursquareTemplate foursquare, boolean isAuthorized) {
		super(foursquare, isAuthorized);
	}
	
	public Checkin get(String checkinId) {
		return get(checkinId, null);
	}
	
	public Checkin get(String checkinId, String signature) {
		Map<String,String> params = new HashMap<String,String>();
		if(signature != null) {
			params.put("signature", signature);
		}
		return get(buildUri(CHECKINS_ENDPOINT + checkinId + "/", params), CheckinContainer.class).getCheckin();
	}

	public Checkin add(CheckinParams params) {
		return post(buildUri(CHECKINS_ENDPOINT + "add/"), params.toParams(), CheckinContainer.class).getCheckin();
	}

}
