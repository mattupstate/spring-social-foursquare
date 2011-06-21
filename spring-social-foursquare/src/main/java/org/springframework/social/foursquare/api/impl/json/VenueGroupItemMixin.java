package org.springframework.social.foursquare.api.impl.json;

import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.foursquare.api.Reasons;
import org.springframework.social.foursquare.api.Tip;
import org.springframework.social.foursquare.api.Venue;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class VenueGroupItemMixin {
	@JsonCreator
	VenueGroupItemMixin(
			@JsonProperty("reasons") Reasons reasons,
			@JsonProperty("venue") Venue venue,
			@JsonProperty("tips") List<Tip> tips){}
}
