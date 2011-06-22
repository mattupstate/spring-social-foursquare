package org.springframework.social.foursquare.api;

public interface SettingOperations {
	
	/**
	 * Retrieve the values of all the authenticated user's settings
	 * @return	All settings
	 */
	AllSettings getAll();
	
	/**
	 * Retrieve a boolean setting value 
	 * @param settingId	The setting ID/name
	 * @return	The setting value
	 */
	Boolean getSetting(String settingId);
	
	
	/**
	 * Change a setting value
	 * @param settingId	Setting name
	 * @param value	true or false
	 * @return	A confirmation message
	 */
	String setSetting(String settingId, Boolean value);
	
	public static final String SETTINGS_ENDPOINT = "settings/";
}
