package org.springframework.social.foursquare.api.impl.json;

import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.foursquare.api.TipGroup;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class VenueTipsMixin {
	@JsonCreator
	VenueTipsMixin(
			@JsonProperty("count") int count, 
			@JsonProperty("groups") List<TipGroup> groups) {}
}
