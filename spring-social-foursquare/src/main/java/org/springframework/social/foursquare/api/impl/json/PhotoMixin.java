package org.springframework.social.foursquare.api.impl.json;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.foursquare.api.FoursquareUser;
import org.springframework.social.foursquare.api.PhotoSizes;
import org.springframework.social.foursquare.api.PhotoSource;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class PhotoMixin {
	@JsonCreator
	PhotoMixin(
			@JsonProperty("id") String id,
			@JsonProperty("createdAt") Date createdAt,
			@JsonProperty("url") String url,
			@JsonProperty("sizes") PhotoSizes sizes,
			@JsonProperty("source") PhotoSource source,
			@JsonProperty("user") FoursquareUser user){}
}
