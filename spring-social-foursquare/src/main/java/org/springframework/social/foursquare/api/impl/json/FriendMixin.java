package org.springframework.social.foursquare.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class FriendMixin {
	@JsonCreator
	FriendMixin(
			@JsonProperty("id") long id, 
			@JsonProperty("firstName") String firstName, 
			@JsonProperty("lastName") String lastName, 
			@JsonProperty("photoUrl") String photoUrl,
			@JsonProperty("gender") String gender, 
			@JsonProperty("homeCity") String homeCity, 
			@JsonProperty("relationship") String relationship) {}
}
