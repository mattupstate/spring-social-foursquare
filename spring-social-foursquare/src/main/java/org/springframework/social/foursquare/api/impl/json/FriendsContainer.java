package org.springframework.social.foursquare.api.impl.json;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.foursquare.api.Friends;

@JsonDeserialize(using=FriendsContainerDeserializer.class)
public class FriendsContainer {
	private Friends friends;

	public FriendsContainer(Friends friends) {
		this.friends = friends;
	}

	public Friends getFriends() {
		return friends;
	}
}
