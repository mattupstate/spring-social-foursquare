package org.springframework.social.foursquare.api.impl.json;

import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.foursquare.api.Category;
import org.springframework.social.foursquare.api.ContactInfo;
import org.springframework.social.foursquare.api.HereNow;
import org.springframework.social.foursquare.api.Location;
import org.springframework.social.foursquare.api.PhotoGroups;
import org.springframework.social.foursquare.api.Special;
import org.springframework.social.foursquare.api.VenueStats;
import org.springframework.social.foursquare.api.VenueTips;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class VenueMixin {
	@JsonCreator
	VenueMixin(
			@JsonProperty("id") String id, 
			@JsonProperty("name") String name, 
			@JsonProperty("contact") ContactInfo contactInfo, 
			@JsonProperty("location") Location location, 
			@JsonProperty("categories") List<Category> categories,
			@JsonProperty("verified") boolean verified, 
			@JsonProperty("stats") VenueStats stats){}
	
	@JsonProperty("url")
	String url;
	
	@JsonProperty("hereNow")
	HereNow hereNow;
	
	@JsonProperty("tips")
	VenueTips tips;
	
	@JsonProperty("tags")
	List<String> tags;
	
	@JsonProperty("specials")
	List<Special> specials;

	@JsonProperty("specialsNearby")
	List<Special> specialsNearby;
	
	@JsonProperty("shortUrl")
	String shortUrl;
	
	@JsonProperty("timezone")
	String timezone;
	
	@JsonProperty("beenHere")
	Map<String,Integer> beenHere;
	
	@JsonProperty("photos")
	PhotoGroups photos;
	
	@JsonProperty("description")
	String description;
}
