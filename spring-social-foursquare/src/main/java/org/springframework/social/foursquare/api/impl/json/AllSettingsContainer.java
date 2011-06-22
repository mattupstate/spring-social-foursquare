package org.springframework.social.foursquare.api.impl.json;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.foursquare.api.AllSettings;

@JsonDeserialize(using=AllSettingsContainerDeserializer.class)
public class AllSettingsContainer {
	
	private AllSettings settings;
	
	public AllSettingsContainer(AllSettings settings) {
		this.settings = settings;
	}
	
	public AllSettings getSettings() {
		return settings;
	}
}
