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
	
	/**
	 * Checkin the authenticated user to a specified venue
	 * @param params	Checkin parameters
	 * @return	The newly created Checkin
	 */
	Checkin add(CheckinParams params);
	
	/**
	 * Returns a list of recent checkins from friends of the authenticated user.
	 * @param latitude	Latitude
	 * @param longitude	Longitude
	 * @param afterTimestamp	Seconds after which to retrieve checkins
	 * @param limit	Result set limit
	 * @return	A list of checkins
	 */
	List<Checkin> getRecent(Double latitude, Double longitude, Long afterTimestamp, Integer limit);
	
	/**
	 * Add a comment to the specified checkin
	 * @param checkinId	Checkin ID
	 * @param text	Comment text
	 * @return	The created comment
	 */
	CheckinComment addComment(String checkinId, String text);
	
	/**
	 * Remove a comment on a checkin made by the authenticated user
	 * @param checkinId	Checkin ID
	 * @param commentId	Comment ID
	 * @return	The checkin object minus the specified comment
	 */
	Checkin deleteComment(String checkinId, String commentId);
	
	public static final String CHECKINS_ENDPOINT = "checkins/";
}
