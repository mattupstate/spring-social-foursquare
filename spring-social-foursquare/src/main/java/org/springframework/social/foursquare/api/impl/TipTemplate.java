package org.springframework.social.foursquare.api.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.social.foursquare.api.Tip;
import org.springframework.social.foursquare.api.TipOperations;
import org.springframework.social.foursquare.api.Todo;
import org.springframework.social.foursquare.api.impl.json.TipContainer;
import org.springframework.social.foursquare.api.impl.json.TipsListContainer;
import org.springframework.social.foursquare.api.impl.json.TodoContainer;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class TipTemplate extends AbstractFoursquareOperations implements TipOperations {
	
	public TipTemplate(FoursquareTemplate foursquare, boolean isAuthorized) {
		super(foursquare, isAuthorized);
	}

	public Tip get(String tipId) {
		return get(buildUri(TIPS_ENDPOINT + tipId), TipContainer.class).getTip();
	}

	public Tip add(String venueId, String text, String url) {
		requireUserAuthorization();
		MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
		params.add("venueId", venueId);
		params.add("text", text);
		params.add("url", url);
		return post(buildUri(TIPS_ENDPOINT + "add"), params, TipContainer.class).getTip();
	}

	public List<Tip> search(Double latitude, Double longitude, String query, Integer offset, boolean friendsOnly) {
		Map<String,String> params = new HashMap<String,String>();
		if(latitude != null && longitude != null) {
			params.put("ll", latitude.toString() + "," + longitude.toString());
		}
		if(query != null) {
			params.put("query", query);
		}
		if(offset != null) {
			params.put("offset", offset.toString());
		}
		if(friendsOnly) {
			params.put("filter", "friends");
		}
		return get(buildUri(TIPS_ENDPOINT + "search", params), TipsListContainer.class).getTips();
	}

	public Todo markTodo(String tipId) {
		requireUserAuthorization();
		return post(buildUri(TIPS_ENDPOINT + tipId + "/marktodo"), new LinkedMultiValueMap<String, Object>(), TodoContainer.class).getTodo();
	}

	public Todo markDone(String tipId) {
		requireUserAuthorization();
		return post(buildUri(TIPS_ENDPOINT + tipId + "/markdone"), new LinkedMultiValueMap<String, Object>(), TodoContainer.class).getTodo();
	}

	public Tip unmarkTodo(String tipId) {
		requireUserAuthorization();
		return post(buildUri(TIPS_ENDPOINT + tipId + "/unmark"), new LinkedMultiValueMap<String, Object>(), TipContainer.class).getTip();
	}
	
}
