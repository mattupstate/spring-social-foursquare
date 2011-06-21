package org.springframework.social.foursquare.api.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.social.foursquare.api.Category;
import org.springframework.social.foursquare.api.ExploreQuery;
import org.springframework.social.foursquare.api.ExploreResponse;
import org.springframework.social.foursquare.api.Venue;
import org.springframework.social.foursquare.api.VenueOperations;
import org.springframework.social.foursquare.api.VenueSearchQuery;
import org.springframework.social.foursquare.api.impl.json.CategoriesContainer;
import org.springframework.social.foursquare.api.impl.json.ExploreResponseContainer;
import org.springframework.social.foursquare.api.impl.json.VenueContainer;
import org.springframework.social.foursquare.api.impl.json.VenueSearchContainer;
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

	public List<Category> getCategories() {
		return get(buildUri(VENUES_ENDPOINT + "categories/"), CategoriesContainer.class).getCategories();
	}
	
	public ExploreResponse explore(ExploreQuery query) {
	    return get(buildUri(VENUES_ENDPOINT + "explore/", query.toParameters()), ExploreResponseContainer.class).getResponse();
	}

    public List<Venue> search(VenueSearchQuery query) {
        return get(buildUri(VENUES_ENDPOINT + "search/", query.toParameters()), VenueSearchContainer.class).getVenues();
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
        return get(buildUri(VENUES_ENDPOINT + "trending/", params), VenueSearchContainer.class).getVenues();
    }
    
    

}
