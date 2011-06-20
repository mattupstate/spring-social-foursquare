package org.springframework.social.foursquare.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class VenueSpecialMixin {
	@JsonCreator
	public VenueSpecialMixin(
			@JsonProperty("id") String id,
			@JsonProperty("type") String type, 
			@JsonProperty("message") String message, 
			@JsonProperty("description") String description, 
			@JsonProperty("unlocked") boolean unlocked,			
			@JsonProperty("icon") String icon, 
			@JsonProperty("title") String title, 
			@JsonProperty("state") String state, 
			@JsonProperty("provider") String provider, 
			@JsonProperty("redemption") String redemption) {}
}
