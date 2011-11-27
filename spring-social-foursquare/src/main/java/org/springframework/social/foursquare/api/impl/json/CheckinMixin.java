package org.springframework.social.foursquare.api.impl.json;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.foursquare.api.CheckinCommentInfo;
import org.springframework.social.foursquare.api.CheckinSource;
import org.springframework.social.foursquare.api.FoursquareUser;
import org.springframework.social.foursquare.api.Photos;
import org.springframework.social.foursquare.api.Venue;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class CheckinMixin {
	@JsonCreator
	CheckinMixin(
			@JsonProperty("id") String id, 
			@JsonProperty("user") FoursquareUser user,
			@JsonProperty("createdAt") @JsonDeserialize(using=FoursquareDateDeserializer.class) Date createdAt, 
			@JsonProperty("type") String type, 
			@JsonProperty("timeZone") String timeZone, 
			@JsonProperty("venue") Venue venue,
			@JsonProperty("source") CheckinSource source,
			@JsonProperty("comments") CheckinCommentInfo comments) {}
	
	@JsonProperty("isMayor") 
	boolean mayor;
	
	@JsonProperty("shout") 
	String shout;
	
	@JsonProperty("")
	Photos photos;
}
