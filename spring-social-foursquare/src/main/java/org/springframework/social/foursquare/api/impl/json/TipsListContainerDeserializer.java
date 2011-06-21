package org.springframework.social.foursquare.api.impl.json;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.social.foursquare.api.Tip;

public class TipsListContainerDeserializer extends AbstractFoursquareDeserializer<TipsListContainer> {

	@SuppressWarnings("unchecked")
	@Override
	public TipsListContainer deserialize(JsonParser jp,
			DeserializationContext ctxt) throws IOException,
			JsonProcessingException {
		return new TipsListContainer((List<Tip>) deserializeNestedList(jp, "tips", new TypeReference<List<Tip>>() { }));
	}
}
