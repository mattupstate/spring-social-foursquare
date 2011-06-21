package org.springframework.social.foursquare.api;

import java.util.List;

public interface TipOperations {
	
	/**
	 * Retrieve a detailed tip
	 * @param tipId	Tip ID
	 * @return	Tip object
	 */
	Tip get(String tipId);
	
	/**
	 * Add a tip to a venue
	 * @param venueId	Foursquare venue ID
	 * @param text	Tip text
	 * @param url	URL related to the tip
	 * @return	The new Tip
	 */
	Tip add(String venueId, String text, String url);
	
	/**
	 * Retrieve a list of tips near the area specified. 
	 * @param latitude Latitude
	 * @param longitude	Longitude
	 * @param query	String query
	 * @param offset	Result set offset
	 * @param friendsOnly	Show only tips from friends
	 * @return	A list of tips
	 */
	List<Tip> search(Double latitude, Double longitude, String query, Integer offset, boolean friendsOnly);
	
	/**
	 * Mark a tip for the authenticated user as something they should do
	 * @param tipId	Tip ID
	 * @return	The marked todo 
	 */
	Todo markTodo(String tipId);
	
	/**
	 * Mark a tip as completed
	 * @param tipId	Tip ID
	 * @return	The marked todo 
	 */
	Todo markDone(String tipId);
	
	/**
	 * Remove a tip from the authenticated user's todo list or done list
	 * @param tipId	Tip ID
	 * @return	The tip acted on
	 */
	Tip unmarkTodo(String tipId);
	
	public static final String TIPS_ENDPOINT = "tips/";
	
}
