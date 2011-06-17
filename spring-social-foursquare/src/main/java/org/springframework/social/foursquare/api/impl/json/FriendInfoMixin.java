package org.springframework.social.foursquare.api.impl.json;

import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.foursquare.api.FriendGroup;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class FriendInfoMixin {
	@JsonCreator
	FriendInfoMixin(
			@JsonProperty("count") int total,
			@JsonProperty("groups") List<FriendGroup> groups){}
}
