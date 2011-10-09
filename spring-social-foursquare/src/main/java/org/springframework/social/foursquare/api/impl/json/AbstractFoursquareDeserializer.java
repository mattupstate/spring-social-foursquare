package org.springframework.social.foursquare.api.impl.json;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.type.TypeReference;

public abstract class AbstractFoursquareDeserializer<T> extends JsonDeserializer<T> {
    
	PrintStream actualStdout = new PrintStream(new FileOutputStream(FileDescriptor.out));
	
    public List<?> deserializeNestedList(JsonParser jp, String propertyName, TypeReference typeRef) 
            throws IOException, JsonProcessingException {
    	while (true) {
			String fieldname = jp.getCurrentName();
			jp.nextToken();
			if("response".equals(fieldname)) {
                while(jp.nextToken() != JsonToken.END_OBJECT) {
                    String responseField = jp.getCurrentName();
                    jp.nextToken();
                    if(propertyName.equals(responseField)) {
                        List<?> result = (List) jp.readValueAs(typeRef);
                        //actualStdout.println(result.toString());
                        return result;
                    }
                }
            }
        }
    }
    
	public <C> C deserializeNestedResponseObject(JsonParser jp, String responseProperty, Class<C> responseType)
		    throws IOException, JsonProcessingException {
		while (true) {
			String fieldname = jp.getCurrentName();
			jp.nextToken();
			if("response".equals(fieldname)) {
				while(jp.nextToken() != JsonToken.END_OBJECT) {
					String responseField = jp.getCurrentName();
					jp.nextToken();
					if(responseProperty.equals(responseField)) {
						return jp.readValueAs(responseType);
					}
				}
			}
        }
	}
	
	public <C> C deserializeResponseObject(JsonParser jp, Class<C> container, Class<?> containee)
            throws IOException, JsonProcessingException {
	    
		while (true) {
			String fieldname = jp.getCurrentName();
			jp.nextToken();
			if("response".equals(fieldname)) {
                try {
                    return container.getConstructor(containee).newInstance(jp.readValueAs(containee));
                } catch (Exception e) {
                    
                    return null;
                }
            }
        }
	}
	
}
