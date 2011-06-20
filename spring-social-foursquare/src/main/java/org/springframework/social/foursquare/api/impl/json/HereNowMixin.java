package org.springframework.social.foursquare.api.impl.json;

import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.foursquare.api.FoursquareUserGroup;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class HereNowMixin {
	@JsonCreator
	HereNowMixin(
			@JsonProperty("count") int count,
			@JsonProperty("groups") List<FoursquareUserGroup> groups){}
}
