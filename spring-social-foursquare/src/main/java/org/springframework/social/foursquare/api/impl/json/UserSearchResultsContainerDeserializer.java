package org.springframework.social.foursquare.api.impl.json;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.springframework.social.foursquare.api.UserSearchResults;

public class UserSearchResultsContainerDeserializer extends JsonDeserializer<UserSearchResultsContainer> {
    
    @Override
    public UserSearchResultsContainer deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        
        while (jp.nextToken() != JsonToken.END_OBJECT) {
            String fieldname = jp.getCurrentName();
            jp.nextToken();
            if("meta".equals(fieldname)) {
                jp.clearCurrentToken(); // we can ignore this for now
                jp.nextToken();
            } else if("response".equals(fieldname)) {
                return new UserSearchResultsContainer(jp.readValueAs(UserSearchResults.class));
            }
        }
        return null;
    }
    
}
