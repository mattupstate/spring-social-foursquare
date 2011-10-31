package org.springframework.social.foursquare.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class LocationMixin {
	@JsonCreator
	LocationMixin(
			@JsonProperty("address") String address, 
			@JsonProperty("crossStreet") String crossStreet, 
			@JsonProperty("city") String city, 
			@JsonProperty("state") String state,
			@JsonProperty("postalCode") String postalCode, 
			@JsonProperty("country") String country, 
			@JsonProperty("lat") double latitude, 
			@JsonProperty("lng") double longitude){}
	
	@JsonProperty("distance")
	int distance;
	
}
