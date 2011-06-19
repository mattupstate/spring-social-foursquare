package org.springframework.social.foursquare.api;

public interface UserOperations {

    /**
     * Retrieve the currently authenticated user profile
     * @return A FoursquareUser
     */
	FoursquareUser getUser();
	
	/**
	 * Retrieve the authenticated user's leaderboard
	 * @return A Leaderboard
	 */
	Leaderboard getLeaderboard();
	
	/**
     * Retrieve the authenticated user's leaderboard, only returning the user and neighbors in rank.
     * Number of friends' scores to return that are adjacent to the authenticated user's score, in 
     * ranked order. The current user's score is returned as well. An odd number of neighbors returns 
     * one more user ahead of the current user than behind. If the current user is at the top of the 
     * leaderboard, only the neighbors behind the current user are returned. If the current user is 
     * at the bottom of the leaderboard, only the neighbors ahead of the current user are returned.
     * @param neighbors The number of friends' scores to return that are adjacent in ranked order.
     * @return A Leaderboard
     */
	Leaderboard getLeaderboard(int neighbors);
	
	public static final String USERS_ENDPOINT = "users/";
}
