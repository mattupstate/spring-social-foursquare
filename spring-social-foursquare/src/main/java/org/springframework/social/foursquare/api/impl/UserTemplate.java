package org.springframework.social.foursquare.api.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.social.foursquare.api.FoursquareUser;
import org.springframework.social.foursquare.api.Leaderboard;
import org.springframework.social.foursquare.api.UserOperations;
import org.springframework.social.foursquare.api.UserSearchResults;
import org.springframework.social.foursquare.api.impl.json.FoursquareUserContainer;
import org.springframework.social.foursquare.api.impl.json.LeaderboardContainer;
import org.springframework.util.StringUtils;

public class UserTemplate extends AbstractFoursquareOperations implements UserOperations {
	
	public UserTemplate(FoursquareTemplate foursquare, boolean isAuthorized) {
		super(foursquare, isAuthorized);
	}
	
	public FoursquareUser getUser() {
		requireUserAuthorization();
		return get(buildUri(USERS_ENDPOINT + "self/"), FoursquareUserContainer.class).getUser();
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
    
    public List<FoursquareUser> search(List<String> phoneNumbers, List<String> emailAddresses,
            List<String> twitterUsernames, List<String> facebookUserIds) {
        Map<String,String> params = new HashMap<String, String>();
        if(phoneNumbers != null) {
            params.put("phone", StringUtils.collectionToCommaDelimitedString(phoneNumbers));
        }
        if(emailAddresses != null) {
            params.put("email", StringUtils.collectionToCommaDelimitedString(emailAddresses));
        }
        if(twitterUsernames != null) {
            params.put("twitter", StringUtils.collectionToCommaDelimitedString(twitterUsernames));
        }
        if(facebookUserIds != null) {
            params.put("fbid", StringUtils.collectionToCommaDelimitedString(facebookUserIds));
        }
        return get(buildUri(USERS_ENDPOINT + "search/", params), UserSearchResults.class).getResults();
    }
    
    public List<FoursquareUser> search(String name) {
        return null;
    }
        
    public List<FoursquareUser> searchByTwitterSource(String twitterUsername) {
        return null;
    }

}
