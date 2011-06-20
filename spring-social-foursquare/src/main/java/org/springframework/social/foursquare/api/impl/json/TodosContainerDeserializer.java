package org.springframework.social.foursquare.api.impl.json;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.springframework.social.foursquare.api.Todos;

public class TodosContainerDeserializer extends AbstractFoursquareDeserializer<TodosContainer> {
	@Override
	public TodosContainer deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		return new TodosContainer(deserializeNestedResponseObject(jp, "todos", Todos.class));
	}
}
