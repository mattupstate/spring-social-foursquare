package org.springframework.social.foursquare.api.impl;

import org.springframework.social.foursquare.api.AllSettings;
import org.springframework.social.foursquare.api.SettingOperations;
import org.springframework.social.foursquare.api.impl.json.AllSettingsContainer;
import org.springframework.social.foursquare.api.impl.json.BooleanValueContainer;
import org.springframework.social.foursquare.api.impl.json.StringValueContainer;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class SettingTemplate extends AbstractFoursquareOperations implements SettingOperations {

	public SettingTemplate(FoursquareTemplate foursquare, boolean isAuthorized) {
		super(foursquare, isAuthorized);
	}

	public AllSettings getAll() {
		requireUserAuthorization();
		return get(buildUri(SETTINGS_ENDPOINT + "all"), AllSettingsContainer.class).getSettings();
	}

	public Boolean getSetting(String settingId) {
		requireUserAuthorization();
		return get(buildUri(SETTINGS_ENDPOINT + settingId), BooleanValueContainer.class).getValue();
	}
	
	public String setSetting(String settingId, Boolean value) {
		requireUserAuthorization();
		MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
		params.add("value", (value) ? "1" : "0");
		return post(buildUri(SETTINGS_ENDPOINT + settingId + "/set"), params, StringValueContainer.class).getValue();
	}
	
}
