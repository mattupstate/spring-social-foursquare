package org.springframework.social.foursquare.api.impl.json;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.social.foursquare.api.Checkin;

public class CheckinListContainerDeserializer extends AbstractFoursquareDeserializer<CheckinListContainer> {
	@SuppressWarnings("unchecked")
	@Override
	public CheckinListContainer deserialize(JsonParser jp, DeserializationContext ctxt) 
			throws IOException, JsonProcessingException {
		return new CheckinListContainer((List<Checkin>) deserializeNestedList(jp, "recent", new TypeReference<List<Checkin>>() {}));
	}
}
