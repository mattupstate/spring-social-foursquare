package org.springframework.social.foursquare.api.impl.json;

import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.foursquare.api.Category;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class CategoryMixin {
	@JsonCreator
	CategoryMixin(
			@JsonProperty("id") String id, 
			@JsonProperty("name") String name, 
			@JsonProperty("pluralName") String pluralName, 
			@JsonProperty("iconUrl") String iconUrl,
			@JsonProperty("primary") boolean primary) {}
	
	@JsonProperty("parents") 
	List<String> parents;
	
	@JsonProperty("categories") 
	List<Category> children;
}
