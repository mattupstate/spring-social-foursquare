package org.springframework.social.foursquare.api.impl.json;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.JsonDeserializer;

public abstract class AbstractFoursquareDeserializer<T, C> extends JsonDeserializer<T> {

	private String responseProperty;
	private Class<C> responseType;
	
	AbstractFoursquareDeserializer(String responseProperty, Class<C> responseType) {
		this.responseProperty = responseProperty;
		this.responseType = responseType;
	}
	
	public C getNestedObject(JsonParser jp)
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
	
	public List<C> getNestedList(JsonParser jp) {
		return null;
	}
	
}
