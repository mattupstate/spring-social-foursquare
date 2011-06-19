package org.springframework.social.foursquare.api.impl.json;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.JsonDeserializer;

public abstract class AbstractFoursquareDeserializer<T> extends JsonDeserializer<T> {
    
	public <C> C getNestedObject(JsonParser jp, String responseProperty, Class<C> responseType)
		throws IOException, JsonProcessingException {
		while (jp.nextToken() != JsonToken.END_OBJECT) {
			String fieldname = jp.getCurrentName();
			jp.nextToken();
			if("meta".equals(fieldname)) {
				jp.clearCurrentToken(); // we can ignore this for now
				jp.nextToken();
			} else if("response".equals(fieldname)) {
				while(jp.nextToken() != JsonToken.END_OBJECT) {
					String responseField = jp.getCurrentName();
					jp.nextToken();
					responseType.getClass();
					if(responseProperty.equals(responseField)) {
						return jp.readValueAs(responseType);
					}
				}
			}
        }
		return null;
	}
}
