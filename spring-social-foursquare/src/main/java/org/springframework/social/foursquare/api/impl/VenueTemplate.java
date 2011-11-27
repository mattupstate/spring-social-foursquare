package org.springframework.social.foursquare.api.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.social.foursquare.api.Category;
import org.springframework.social.foursquare.api.CheckinInfo;
import org.springframework.social.foursquare.api.ExploreQuery;
import org.springframework.social.foursquare.api.ExploreResponse;
import org.springframework.social.foursquare.api.Tips;
import org.springframework.social.foursquare.api.Todo;
import org.springframework.social.foursquare.api.Venue;
import org.springframework.social.foursquare.api.VenueLinks;
import org.springframework.social.foursquare.api.VenueOperations;
import org.springframework.social.foursquare.api.Photos;
import org.springframework.social.foursquare.api.VenueSearchParams;
import org.springframework.social.foursquare.api.impl.json.CategoriesContainer;
import org.springframework.social.foursquare.api.impl.json.ExploreResponseContainer;
import org.springframework.social.foursquare.api.impl.json.HereNowContainer;
import org.springframework.social.foursquare.api.impl.json.TipsContainer;
import org.springframework.social.foursquare.api.impl.json.TodoContainer;
import org.springframework.social.foursquare.api.impl.json.VenueContainer;
import org.springframework.social.foursquare.api.impl.json.VenueLinksContainer;
import org.springframework.social.foursquare.api.impl.json.VenuePhotosContainer;
import org.springframework.social.foursquare.api.impl.json.VenueSearchContainer;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class VenueTemplate extends AbstractFoursquareOperations implements VenueOperations {

	public VenueTemplate(FoursquareTemplate foursquare, boolean isAuthorized) {
		super(foursquare, isAuthorized);
	}

	public Venue getVenue(String venueId) {
		return get(buildUri(VENUES_ENDPOINT + venueId), VenueContainer.class).getVenue();
	}

	public Venue addVenue(String name, String address, String crossStreet, String city, String state, 
			String zip, String phone, double latitude, double longitude, String primaryCategoryId) {
		requireUserAuthorization();
		MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
		params.add("name", name);
		params.add("address", address);
		params.add("crossStreet", crossStreet);
		params.add("city", city);
		params.add("state", state);
		params.add("zip", zip);
		params.add("phone", phone);
		params.add("ll", Double.toString(latitude) + "," + Double.toString(longitude));
		params.add("primaryCategoryId", primaryCategoryId);
		return post(buildUri(VENUES_ENDPOINT + "add"), params, VenueContainer.class).getVenue();
	}

	public List<Category> getCategories() {
		return get(buildUri(VENUES_ENDPOINT + "categories"), CategoriesContainer.class).getCategories();
	}
	
	public ExploreResponse explore(ExploreQuery query) {
	    return get(buildUri(VENUES_ENDPOINT + "explore", query.toParameters()), ExploreResponseContainer.class).getResponse();
	}

    public List<Venue> search(VenueSearchParams query) {
        return get(buildUri(VENUES_ENDPOINT + "search", query.toParameters()), VenueSearchContainer.class).getVenues();
    }
    
    public List<Venue> getTrending(double latitude, double longitude, int radius, int limit) {
    	Map<String,String> params = new HashMap<String,String>();
    	params.put("ll", Double.toString(latitude) + "," + Double.toString(longitude));
    	if(radius > 0) {
    		params.put("radius", Integer.toString(radius));
    	}
    	if(limit > 0) {
    		params.put("limit", Integer.toString(limit));
    	}
        return get(buildUri(VENUES_ENDPOINT + "trending", params), VenueSearchContainer.class).getVenues();
    }

	public CheckinInfo getHereNow(String venueId, long afterTimestamp, int offset, int limit) {
		Map<String,String> params = new HashMap<String,String>();
    	if(afterTimestamp > 0) {
    		params.put("afterTimestamp", Long.toString(afterTimestamp));
    	}
    	if(offset > 0) {
    		params.put("offset", Integer.toString(offset));
    	}
    	if(limit > 0) {
    		params.put("limit", Integer.toString(limit));
    	}
		return get(buildUri(VENUES_ENDPOINT + venueId + "/herenow", params), HereNowContainer.class).getCheckinInfo();
	}

	public Tips getTips(String venueId, String sort, int offset, int limit) {
		Map<String,String> params = new HashMap<String,String>();
		sort = (sort == null) ? "popular" : sort;
    	params.put("sort", sort);
    	if(offset > 0) {
    		params.put("offset", Integer.toString(offset));
    	}
    	if(limit > 0) {
    		params.put("limit", Integer.toString(limit));
    	}
		return get(buildUri(VENUES_ENDPOINT + venueId + "/tips", params), TipsContainer.class).getTips();
	}
	
	public Photos getPhotos(String venueId, String group, int offset, int limit) {
		Map<String,String> params = new HashMap<String,String>();
		group = (group == null) ? "venue" : group;
    	params.put("group", group);
    	if(offset > 0) {
    		params.put("offset", Integer.toString(offset));
    	}
    	if(limit > 0) {
    		params.put("limit", Integer.toString(limit));
    	}
		return get(buildUri(VENUES_ENDPOINT + venueId + "/photos", params), VenuePhotosContainer.class).getPhotos();
	}

	public VenueLinks getLinks(String venueId) {
		return get(buildUri(VENUES_ENDPOINT + venueId + "/links"), VenueLinksContainer.class).getLinks();
	}

	public Todo markTodo(String venueId, String text) {
		requireUserAuthorization();
		MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
		if(text != null) {
			params.add("text", text);
		}
		return post(buildUri(VENUES_ENDPOINT + venueId + "/marktodo"), params, TodoContainer.class).getTodo();
	}

	public void flag(String venueId, String problem) {
		requireUserAuthorization();
		MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
		params.add("problem", problem);
		post(buildUri(VENUES_ENDPOINT + venueId + "/flag"), params, Map.class);
	}
    
	public void edit(String venueId, String name, String address, String crossStreet, String city, String state, 
			String zip, String phone, double latitude, double longitude, String categoryId) {
		requireUserAuthorization();
		MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
		params.add("name", name);
		params.add("address", address);
		params.add("crossStreet", crossStreet);
		params.add("city", city);
		params.add("state", state);
		params.add("zip", zip);
		params.add("phone", phone);
		params.add("ll", Double.toString(latitude) + "," + Double.toString(longitude));
		params.add("categoryId", categoryId);
		post(buildUri(VENUES_ENDPOINT + venueId + "/edit"), params, Map.class);
	}
	
	public void proposeEdit(String venueId, String name, String address, String crossStreet, String city, String state, 
			String zip, String phone, double latitude, double longitude, String primaryCategoryId) {
		requireUserAuthorization();
		MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
		params.add("name", name);
		params.add("address", address);
		params.add("crossStreet", crossStreet);
		params.add("city", city);
		params.add("state", state);
		params.add("zip", zip);
		params.add("phone", phone);
		params.add("ll", Double.toString(latitude) + "," + Double.toString(longitude));
		params.add("primaryCategoryId", primaryCategoryId);
		post(buildUri(VENUES_ENDPOINT + venueId + "/proposeedit"), params, Map.class);
	}

}
