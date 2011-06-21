package org.springframework.social.foursquare.api;

public interface CheckinOperations {
	
	/**
	 * Retrieve a detailed checkin
	 * @param checkinId	Checkin ID
	 * @return	Checkin
	 */
	Checkin get(String checkinId);
	
	/**
	 * Retrieve a detailed checkin
	 * @param checkinId	Checkin ID
	 * @param signature Signature for third party services such as Twitter
	 * @return	Checkin
	 */
	Checkin get(String checkinId, String signature);
	
	Checkin add(CheckinParams params);
	
	public static final String CHECKINS_ENDPOINT = "checkins/";
}
