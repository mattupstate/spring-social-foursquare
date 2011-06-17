package org.springframework.social.foursquare.api.impl.json;

import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.foursquare.api.Category;
import org.springframework.social.foursquare.api.ContactInfo;
import org.springframework.social.foursquare.api.Location;
import org.springframework.social.foursquare.api.VenueStats;

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
}
