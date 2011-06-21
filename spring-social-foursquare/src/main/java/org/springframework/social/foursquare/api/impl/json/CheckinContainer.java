package org.springframework.social.foursquare.api.impl.json;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.foursquare.api.Checkin;

@JsonDeserialize(using=CheckinContainerDeserializer.class)
public class CheckinContainer {
	
	private Checkin checkin;
	
	public CheckinContainer(Checkin checkin) {
		this.checkin = checkin;
	}

	public Checkin getCheckin() {
		return checkin;
	}
}
