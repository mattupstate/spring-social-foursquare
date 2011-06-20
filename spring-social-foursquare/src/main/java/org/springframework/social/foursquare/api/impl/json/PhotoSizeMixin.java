package org.springframework.social.foursquare.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class PhotoSizeMixin {
	@JsonCreator
	PhotoSizeMixin(
			@JsonProperty("url") String url, 
			@JsonProperty("width") int width, 
			@JsonProperty("height") int height){}
}
