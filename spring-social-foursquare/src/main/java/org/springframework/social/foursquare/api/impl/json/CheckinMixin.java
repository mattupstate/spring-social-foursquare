package org.springframework.social.foursquare.api.impl.json;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.foursquare.api.Venue;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class CheckinMixin {
	@JsonCreator
	CheckinMixin(
			@JsonProperty("id") String id, 
			@JsonProperty("createdAt") Date createdAt, 
			@JsonProperty("type") String type, 
			@JsonProperty("isMayor") boolean mayor, 
			@JsonProperty("timeZone") String timeZone, 
			@JsonProperty("venue") Venue venue) {}
	
}
