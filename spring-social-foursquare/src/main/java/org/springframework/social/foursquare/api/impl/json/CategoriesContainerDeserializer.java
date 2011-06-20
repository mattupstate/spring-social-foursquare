package org.springframework.social.foursquare.api.impl.json;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.social.foursquare.api.Category;

public class CategoriesContainerDeserializer extends AbstractFoursquareDeserializer<CategoriesContainer> {
	@SuppressWarnings("unchecked") 
	@Override
	public CategoriesContainer deserialize(JsonParser jp, DeserializationContext ctxt) 
			throws IOException, JsonProcessingException {
		return new CategoriesContainer((List<Category>) deserializeNestedList(jp, "categories", new TypeReference<List<Category>>(){}));
	}
}
