package org.springframework.social.foursquare.api.impl.json;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.springframework.social.foursquare.api.Tips;

public class TipsContainerDeserializer extends AbstractFoursquareDeserializer<TipsContainer> {
	@Override
	public TipsContainer deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		return new TipsContainer(deserializeNestedResponseObject(jp, "tips", Tips.class));
	}
}
