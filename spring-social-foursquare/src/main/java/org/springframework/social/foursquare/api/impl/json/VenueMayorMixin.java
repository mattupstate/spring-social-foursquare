package org.springframework.social.foursquare.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.foursquare.api.FoursquareUser;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class VenueMayorMixin {
	@JsonCreator
	VenueMayorMixin(
			@JsonProperty("count") int count,
			@JsonProperty("user") FoursquareUser user){}
}
