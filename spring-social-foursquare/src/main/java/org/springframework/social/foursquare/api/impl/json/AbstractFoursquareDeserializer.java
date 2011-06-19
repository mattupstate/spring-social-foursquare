package org.springframework.social.foursquare.api.impl.json;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.type.TypeReference;

public abstract class AbstractFoursquareDeserializer<T> extends JsonDeserializer<T> {
    
    public List<?> deserializeNestedList(JsonParser jp, String propertyName, TypeReference typeRef) 
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
                    if(propertyName.equals(responseField)) {
                        return (List) jp.readValueAs(typeRef);
                    }
                }
            }
        }
        return null;
    }
    
	public <C> C deserializeNestedResponseObject(JsonParser jp, String responseProperty, Class<C> responseType)
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
					if(responseProperty.equals(responseField)) {
						return jp.readValueAs(responseType);
					}
				}
			}
        }
		return null;
	}
	
	public <C> C deserializeResponseObject(JsonParser jp, Class<C> container, Class<?> containee)
            throws IOException, JsonProcessingException {
	    while (jp.nextToken() != JsonToken.END_OBJECT) {
            String fieldname = jp.getCurrentName();
            jp.nextToken();
            if("meta".equals(fieldname)) {
                jp.clearCurrentToken(); // we can ignore this for now
                jp.nextToken();
            } else if("response".equals(fieldname)) {
                try {
                    return container.getConstructor(containee).newInstance(jp.readValueAs(containee));
                } catch (Exception e) {
                    return null;
                }
            }
        }
        return null;
	}
	
}
