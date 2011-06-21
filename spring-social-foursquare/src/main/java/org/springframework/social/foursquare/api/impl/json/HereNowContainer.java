package org.springframework.social.foursquare.api.impl.json;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.foursquare.api.CheckinInfo;

@JsonDeserialize(using=HereNowContainerDeserializer.class)
public class HereNowContainer {
	
	private CheckinInfo checkinInfo;
	
	public HereNowContainer(CheckinInfo checkinInfo) {
		this.checkinInfo = checkinInfo;
	}
	
	public CheckinInfo getCheckinInfo() {
		return checkinInfo;
	}
}
