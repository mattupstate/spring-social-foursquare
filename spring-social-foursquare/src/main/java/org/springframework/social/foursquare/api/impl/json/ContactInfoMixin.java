package org.springframework.social.foursquare.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class ContactInfoMixin {
	@JsonCreator
	ContactInfoMixin(
			@JsonProperty("email") String email,
			@JsonProperty("twitter") String twitter,
			@JsonProperty("phone") String phone,
			@JsonProperty("formattedPhone") String formattedPhone) {}

}
