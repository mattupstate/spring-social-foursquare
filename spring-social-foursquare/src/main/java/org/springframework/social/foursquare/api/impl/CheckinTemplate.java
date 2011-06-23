package org.springframework.social.foursquare.api.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.social.foursquare.api.Checkin;
import org.springframework.social.foursquare.api.CheckinComment;
import org.springframework.social.foursquare.api.CheckinOperations;
import org.springframework.social.foursquare.api.CheckinParams;
import org.springframework.social.foursquare.api.impl.json.CheckinCommentContainer;
import org.springframework.social.foursquare.api.impl.json.CheckinContainer;
import org.springframework.social.foursquare.api.impl.json.CheckinListContainer;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

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
		return get(buildUri(CHECKINS_ENDPOINT + checkinId, params), CheckinContainer.class).getCheckin();
	}

	public Checkin add(CheckinParams params) {
		requireUserAuthorization();
		return post(buildUri(CHECKINS_ENDPOINT + "add"), params.toParams(), CheckinContainer.class).getCheckin();
	}

	public List<Checkin> getRecent(Double latitude, Double longitude, Long afterTimestamp, Integer limit) {
		requireUserAuthorization();
		Map<String,String> params = new HashMap<String,String>();
		if(latitude != null && longitude != null) {
			params.put("ll", latitude.toString() + "," + longitude.toString());
		}
		if(afterTimestamp != null) {
			params.put("afterTimestamp", afterTimestamp.toString());
		}
		if(limit != null) {
			params.put("limit", limit.toString());
		}
		return get(buildUri(CHECKINS_ENDPOINT + "recent", params), CheckinListContainer.class).getCheckins();
	}

	public CheckinComment addComment(String checkinId, String text) {
		requireUserAuthorization();
		MultiValueMap<String,Object> params = new LinkedMultiValueMap<String, Object>();
		params.add("text", text);
		return post(buildUri(CHECKINS_ENDPOINT + checkinId + "/addcomment"), params, CheckinCommentContainer.class).getComment();
	}

	public Checkin deleteComment(String checkinId, String commentId) {
		requireUserAuthorization();
		MultiValueMap<String,Object> params = new LinkedMultiValueMap<String, Object>();
		params.add("commentId", commentId);
		return post(buildUri(CHECKINS_ENDPOINT + checkinId + "/deletecomment"), params, CheckinContainer.class).getCheckin();
	}

}
