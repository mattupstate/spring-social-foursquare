package org.springframework.social.foursquare.api.impl.json;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.foursquare.api.Tip;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class TodoMixin {
	@JsonCreator
	TodoMixin(
			@JsonProperty("id") long id,
			@JsonProperty("createdAt") Date createdAt,
			@JsonProperty("tip") Tip tip){}

}
