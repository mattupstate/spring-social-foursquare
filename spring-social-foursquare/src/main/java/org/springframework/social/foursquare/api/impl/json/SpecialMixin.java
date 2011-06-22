package org.springframework.social.foursquare.api.impl.json;

import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.foursquare.api.FoursquareUser;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class SpecialMixin {
	@JsonCreator
	public SpecialMixin(
			@JsonProperty("id") String id,
			@JsonProperty("type") String type, 
			@JsonProperty("message") String message, 
			@JsonProperty("description") String description, 
			@JsonProperty("unlocked") boolean unlocked,			
			@JsonProperty("icon") String icon, 
			@JsonProperty("title") String title, 
			@JsonProperty("state") String state) {}
	
	 
	@JsonProperty("provider") 
	String provider;
	
	@JsonProperty("redemption") 
	String redemption;
	
	@JsonProperty("progress")
	int progress;
	
	@JsonProperty("progressDescription")
	String progressDescription;
	
	@JsonProperty("detail")
	int detail;
	
	@JsonProperty("target")
	int target;
	
	@JsonProperty("friendsHere")
	List<FoursquareUser> friendsHere;
}
