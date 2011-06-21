package org.springframework.social.foursquare.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.foursquare.api.Provider;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class VenueLinkMixin {
	@JsonCreator
	VenueLinkMixin(
			@JsonProperty("provider") Provider provider,
			@JsonProperty("linkedId") String linkedId,
			@JsonProperty("url") String url){}
}
