package org.springframework.social.foursquare.api;

import java.util.List;

public interface UserOperations {

    /**
     * Retrieve the currently authenticated user profile
     * @return A FoursquareUser
     */
	FoursquareUser getUser();
	
	/**
     * Retrieve the specified FoursquareUser
     * @param userId a Foursquare user ID
     * @return A FoursquareUser
     */
    FoursquareUser getUser(String userId);
	
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
	
	/**
	 * Get a list of users with whom the authenticated user has a pending friend request
	 * @return A list of FoursquareUser objects
	 */
	List<FoursquareUser> getRequests();
	
	/**
	 * Search for users by a combination of parameters
	 * @param phoneNumbers A list of phone numbers
	 * @param emailAddresses A list of email addresses
	 * @param twitterHandles A list of Twitter handles
	 * @param facebookUserIds A list of Facebook user IDs
	 * @return A UserSearchResults object containg matching users and a graph of unmatched criteria
	 */
	UserSearchResponse search(List<String> phoneNumbers, List<String> emailAddresses,
            List<String> twitterHandles, List<String> facebookUserIds);
	
	/**
	 * Search for users by name.
	 * @param name A users name
	 * @return A UserSearchResults object containg matching users and a graph of unmatched criteria
	 */
	UserSearchResponse searchByName(String name);
	
	/**
	 * Searches the specified Twitter handle's followers for users who have Foursquare accounts.
	 * @param name A Twitter handle
     * @return A UserSearchResults object containg matching users and a graph of unmatched criteria
	 */
	UserSearchResponse searchTwitterFriends(String twitterHandle);
	
	BadgesResponse getBadges();
	
	BadgesResponse getBadges(String userId);
	
	public static final String USERS_ENDPOINT = "users/";
}
