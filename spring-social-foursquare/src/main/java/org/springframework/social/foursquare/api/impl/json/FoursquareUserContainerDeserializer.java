package org.springframework.social.foursquare.api.impl.json;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.springframework.social.foursquare.api.FoursquareUser;

public class FoursquareUserContainerDeserializer extends AbstractFoursquareDeserializer<FoursquareUserContainer> {
    
	@Override
	public FoursquareUserContainer deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		return new FoursquareUserContainer(deserializeNestedResponseObject(jp, "user", FoursquareUser.class));
	}
	
	
}
