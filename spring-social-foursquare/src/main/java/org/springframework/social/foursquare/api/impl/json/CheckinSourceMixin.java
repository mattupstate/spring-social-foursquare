package org.springframework.social.foursquare.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

abstract class CheckinSourceMixin {
	@JsonCreator
	CheckinSourceMixin(
			@JsonProperty("name") String name, 
			@JsonProperty("url") String url) {}
}
