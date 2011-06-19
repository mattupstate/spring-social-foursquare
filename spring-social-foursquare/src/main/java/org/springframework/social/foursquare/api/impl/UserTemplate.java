package org.springframework.social.foursquare.api.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.social.foursquare.api.BadgesResponse;
import org.springframework.social.foursquare.api.FoursquareUser;
import org.springframework.social.foursquare.api.Leaderboard;
import org.springframework.social.foursquare.api.UserOperations;
import org.springframework.social.foursquare.api.UserSearchResponse;
import org.springframework.social.foursquare.api.impl.json.BadgesResponseContainer;
import org.springframework.social.foursquare.api.impl.json.FoursquareUserContainer;
import org.springframework.social.foursquare.api.impl.json.LeaderboardContainer;
import org.springframework.social.foursquare.api.impl.json.RequestsContainer;
import org.springframework.social.foursquare.api.impl.json.UserSearchResponseContainer;
import org.springframework.util.StringUtils;

public class UserTemplate extends AbstractFoursquareOperations implements UserOperations {
	
	public UserTemplate(FoursquareTemplate foursquare, boolean isAuthorized) {
		super(foursquare, isAuthorized);
	}
	
	public FoursquareUser getUser() {
		return getUser("self");
	}
	
	public FoursquareUser getUser(String userId) {
        requireUserAuthorization();
        return get(buildUri(USERS_ENDPOINT + userId + "/"), FoursquareUserContainer.class).getUser();
    }

    public Leaderboard getLeaderboard() {
        return getLeaderboard(0);
    }

    public Leaderboard getLeaderboard(int neighbors) {
        Map<String,String> params = new HashMap<String, String>();
        if(neighbors > 0) {
            params.put("neighbors", Integer.toString(neighbors));
        }
        return get(buildUri(USERS_ENDPOINT + "leaderboard/", params), LeaderboardContainer.class).getLeaderboard();
    }
    
    public UserSearchResponse search(List<String> phoneNumbers, List<String> emailAddresses,
            List<String> twitterHandles, List<String> facebookUserIds) {
        Map<String,String> params = new HashMap<String, String>();
        if(phoneNumbers != null) {
            params.put("phone", StringUtils.collectionToCommaDelimitedString(phoneNumbers));
        }
        if(emailAddresses != null) {
            params.put("email", StringUtils.collectionToCommaDelimitedString(emailAddresses));
        }
        if(twitterHandles != null) {
            params.put("twitter", StringUtils.collectionToCommaDelimitedString(twitterHandles));
        }
        if(facebookUserIds != null) {
            params.put("fbid", StringUtils.collectionToCommaDelimitedString(facebookUserIds));
        }
        return doSearch(params);
    }
    
    public UserSearchResponse searchByName(String name) {
        Map<String,String> params = new HashMap<String, String>();
        params.put("name", name);
        return doSearch(params);
    }
    
    public UserSearchResponse searchTwitterFriends(String twitterHandle) {
        Map<String,String> params = new HashMap<String, String>();
        params.put("twitterSource", twitterHandle);
        return doSearch(params);
    }
    
    private UserSearchResponse doSearch(Map<String,String> params) {
        requireUserAuthorization();
        return get(buildUri(USERS_ENDPOINT + "search/", params), UserSearchResponseContainer.class).getResults();
    }
    
    public List<FoursquareUser> getRequests() {
        requireUserAuthorization();
        return get(buildUri(USERS_ENDPOINT + "requests/"), RequestsContainer.class).getRequests();
    }

    public BadgesResponse getBadges() {
        return getBadges("self");
    }

    public BadgesResponse getBadges(String userId) {
        requireUserAuthorization();
        return get(buildUri(USERS_ENDPOINT + userId + "/badges/"), BadgesResponseContainer.class).getResponse();
    }
    
}
