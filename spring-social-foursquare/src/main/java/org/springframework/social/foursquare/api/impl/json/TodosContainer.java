package org.springframework.social.foursquare.api.impl.json;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.foursquare.api.Todos;

@JsonDeserialize(using=TodosContainerDeserializer.class)
public class TodosContainer {
	
	private Todos todos;
	
	public TodosContainer(Todos todos) {
		this.todos = todos;
	}
	
	public Todos getTodos() {
		return todos;
	}

}
