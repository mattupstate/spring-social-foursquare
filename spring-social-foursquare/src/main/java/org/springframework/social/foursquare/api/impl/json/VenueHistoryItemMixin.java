package org.springframework.social.foursquare.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.foursquare.api.Venue;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class VenueHistoryItemMixin {
	@JsonCreator
	VenueHistoryItemMixin(
			@JsonProperty("beenHere") int beenHere,
			@JsonProperty("venue") Venue venue){}
}
