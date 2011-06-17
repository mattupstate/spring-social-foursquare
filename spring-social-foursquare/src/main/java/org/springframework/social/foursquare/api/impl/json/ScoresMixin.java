package org.springframework.social.foursquare.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class ScoresMixin {
	@JsonCreator
	ScoresMixin(
			@JsonProperty("recent") int recent,
			@JsonProperty("max") int max,
			@JsonProperty("checkinsCount") int checkinsCount) {}
}
