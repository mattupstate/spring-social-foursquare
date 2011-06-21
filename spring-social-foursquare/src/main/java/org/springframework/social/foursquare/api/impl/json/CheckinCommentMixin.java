package org.springframework.social.foursquare.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class CheckinCommentMixin {
	// TODO: Determine real checkin comment JSON structure
	@JsonCreator
	CheckinCommentMixin(
			@JsonProperty("id") String id,
			@JsonProperty("text") String text){}
}
