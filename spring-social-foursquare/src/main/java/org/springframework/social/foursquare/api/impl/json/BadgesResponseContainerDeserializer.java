package org.springframework.social.foursquare.api.impl.json;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.springframework.social.foursquare.api.BadgesResponse;

public class BadgesResponseContainerDeserializer extends AbstractFoursquareDeserializer<BadgesResponseContainer> {
    @Override 
    public BadgesResponseContainer deserialize(JsonParser jp, DeserializationContext ctxt) 
            throws IOException, JsonProcessingException {
        return deserializeResponseObject(jp, BadgesResponseContainer.class, BadgesResponse.class);
    }
}
