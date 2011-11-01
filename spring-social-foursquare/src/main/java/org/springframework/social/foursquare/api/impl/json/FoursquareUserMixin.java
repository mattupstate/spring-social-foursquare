package org.springframework.social.foursquare.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.foursquare.api.CheckinInfo;
import org.springframework.social.foursquare.api.ContactInfo;
import org.springframework.social.foursquare.api.FriendInfo;
import org.springframework.social.foursquare.api.MayorshipInfo;
import org.springframework.social.foursquare.api.Scores;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class FoursquareUserMixin {
	
	@JsonCreator
	FoursquareUserMixin(
			@JsonProperty("id") String id, 
			@JsonProperty("firstName") String firstName, 
			@JsonProperty("lastName") String lastName, 
			@JsonProperty("photo") String photoUrl,
			@JsonProperty("gender") String gender, 
			@JsonProperty("homeCity") String homeCity, 
			@JsonProperty("relationship") String relationship){}
	
	@JsonProperty("type") 
	String type;
	
	@JsonProperty("pings") 
	boolean pings;
	
	@JsonProperty("contact") 
	ContactInfo contactInfo;
	
	@JsonProperty("mayorships") 
	MayorshipInfo mayorshipInfo; 
	
	@JsonProperty("checkins") 
	CheckinInfo checkinInfo;
	
	@JsonProperty("friends") 
	FriendInfo friendInfo;
	
	@JsonProperty("scores") 
	Scores scores;
	
}
