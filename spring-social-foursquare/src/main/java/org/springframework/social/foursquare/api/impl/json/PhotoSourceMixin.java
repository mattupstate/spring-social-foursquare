package org.springframework.social.foursquare.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class PhotoSourceMixin {
	@JsonCreator
	PhotoSourceMixin(
			@JsonProperty("name") String name,
			@JsonProperty("url") String url){}
}
