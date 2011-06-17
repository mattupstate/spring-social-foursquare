package org.springframework.social.foursquare.api;

public interface Foursquare {
	
	UserOperations userOperations();
	
	VenueOperations venueOperations();
	
	CheckinOperations checkinOperations();
	
	TipOperations tipOperations();
	
	PhotoOperations photoOperations();
	
	SettingOperations settingOperations();
	
	SpecialOperations specialOperations();
	
}
