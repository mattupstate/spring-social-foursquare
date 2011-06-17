package org.springframework.social.foursquare.api.impl.json;

import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.foursquare.api.Venue;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class MayorshipInfoMixin {
	@JsonCreator
	MayorshipInfoMixin(
			@JsonProperty("count") int total,
			@JsonProperty("items") List<Venue> venues){}

}
