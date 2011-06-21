package org.springframework.social.foursquare.api.impl.json;

import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.foursquare.api.VenueLink;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class VenueLinksMixin {
	@JsonCreator
	VenueLinksMixin(
			@JsonProperty("count") int count,
			@JsonProperty("items") List<VenueLink> items){}
}
