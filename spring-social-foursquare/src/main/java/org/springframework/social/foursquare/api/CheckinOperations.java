package org.springframework.social.foursquare.api;

import java.util.List;

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
	
	List<Checkin> getRecent(Double latitude, Double longitude, Long afterTimestamp, Integer limit);
	
	public static final String CHECKINS_ENDPOINT = "checkins/";
}
