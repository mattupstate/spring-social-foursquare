package org.springframework.social.foursquare.api.impl.json;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.foursquare.api.FoursquareUser;
import org.springframework.social.foursquare.api.Venue;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class TipMixin {
	@JsonCreator
	TipMixin(
			@JsonProperty("id") long id,
			@JsonProperty("createdAt") Date createdAt, 
			@JsonProperty("text") String text, 
			@JsonProperty("status") String status, 
			@JsonProperty("todoCount") int todoCount,
			@JsonProperty("doneCount") int doneCount, 
			@JsonProperty("venue") Venue venue, 
			@JsonProperty("user") FoursquareUser user){}
}
