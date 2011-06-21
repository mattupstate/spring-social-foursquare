package org.springframework.social.foursquare.api.impl.json;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.foursquare.api.Todo;

@JsonDeserialize(using=TodoContainerDeserializer.class)
public class TodoContainer {
	private Todo todo;
	
	public TodoContainer(Todo todo) {
		this.todo = todo;
	}
	
	public Todo getTodo() {
		return todo;
	}
}
