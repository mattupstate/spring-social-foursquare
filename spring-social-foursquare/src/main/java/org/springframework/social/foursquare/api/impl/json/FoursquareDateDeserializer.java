package org.springframework.social.foursquare.api.impl.json;

import java.io.IOException;
import java.util.Date;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

public class FoursquareDateDeserializer extends JsonDeserializer<Date> {

	@Override
	public Date deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
        return new Date(Long.valueOf(jp.getText()) * 1000);
	}
}
