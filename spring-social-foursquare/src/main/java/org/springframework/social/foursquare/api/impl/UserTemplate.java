package org.springframework.social.foursquare.api.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.social.foursquare.api.BadgesResponse;
import org.springframework.social.foursquare.api.CheckinInfo;
import org.springframework.social.foursquare.api.FoursquareUser;
import org.springframework.social.foursquare.api.Friends;
import org.springframework.social.foursquare.api.Leaderboard;
import org.springframework.social.foursquare.api.Tips;
import org.springframework.social.foursquare.api.Todos;
import org.springframework.social.foursquare.api.UserOperations;
import org.springframework.social.foursquare.api.UserSearchResponse;
import org.springframework.social.foursquare.api.VenueHistory;
import org.springframework.social.foursquare.api.impl.json.BadgesResponseContainer;
import org.springframework.social.foursquare.api.impl.json.CheckinInfoContainer;
import org.springframework.social.foursquare.api.impl.json.FoursquareUserContainer;
import org.springframework.social.foursquare.api.impl.json.FriendsContainer;
import org.springframework.social.foursquare.api.impl.json.LeaderboardContainer;
import org.springframework.social.foursquare.api.impl.json.RequestsContainer;
import org.springframework.social.foursquare.api.impl.json.TipsContainer;
import org.springframework.social.foursquare.api.impl.json.TodosContainer;
import org.springframework.social.foursquare.api.impl.json.UserSearchResponseContainer;
import org.springframework.social.foursquare.api.impl.json.VenueHistoryContainer;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

/**
 * Implementation of {@link UserOperations}, providing a binding to Foursquare's user-oriented REST resources.
 */
public class UserTemplate extends AbstractFoursquareOperations implements UserOperations {
	
	public UserTemplate(FoursquareTemplate foursquare, boolean isAuthorized) {
		super(foursquare, isAuthorized);
	}
	
	public FoursquareUser getUser() {
		return getUser("self");
	}
	
	public FoursquareUser getUser(String userId) {
        requireUserAuthorization();
        return get(buildUri(USERS_ENDPOINT + userId), FoursquareUserContainer.class).getUser();
    }

    public Leaderboard getLeaderboard() {
        return getLeaderboard(0);
    }

    public Leaderboard getLeaderboard(int neighbors) {
        Map<String,String> params = new HashMap<String, String>();
        if(neighbors > 0) {
            params.put("neighbors", Integer.toString(neighbors));
        }
        return get(buildUri(USERS_ENDPOINT + "leaderboard", params), LeaderboardContainer.class).getLeaderboard();
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
        return get(buildUri(USERS_ENDPOINT + "search", params), UserSearchResponseContainer.class).getResults();
    }
    
    public List<FoursquareUser> getRequests() {
        requireUserAuthorization();
        return get(buildUri(USERS_ENDPOINT + "requests"), RequestsContainer.class).getRequests();
    }

    public BadgesResponse getBadges() {
        return getBadges("self");
    }

    public BadgesResponse getBadges(String userId) {
        requireUserAuthorization();
        return get(buildUri(USERS_ENDPOINT + userId + "/badges"), BadgesResponseContainer.class).getResponse();
    }

	public CheckinInfo getCheckins() {
		return getCheckins("self");
	}
	
	public CheckinInfo getCheckins(int limit, int offset) {
		return getCheckins("self", limit, offset);
	}
	

	public CheckinInfo getCheckins(int beforeTimestamp, int afterTimestamp, int limit, int offset) {
		return getCheckins("self", beforeTimestamp, afterTimestamp, limit, offset); 
	}
	
	public CheckinInfo getCheckins(String userId) {
		requireUserAuthorization();
		return get(buildUri(USERS_ENDPOINT + userId + "/checkins"), CheckinInfoContainer.class).getCheckinInfo();
	}
		
	public CheckinInfo getCheckins(String userId, int limit, int offset) {
		Map<String,String> params = new HashMap<String,String>();
		params.put("limit", Integer.toString(limit));
		params.put("offset", Integer.toString(offset));
		return doGetCheckins(userId, params); 
	}
	
	public CheckinInfo getCheckins(String userId, int beforeTimestamp, int afterTimestamp, int limit, int offset) {
		Map<String,String> params = new HashMap<String,String>();
		params.put("beforeTimestamp", Integer.toString(beforeTimestamp));
		params.put("afterTimestamp", Integer.toString(afterTimestamp));
		params.put("limit", Integer.toString(limit));
		params.put("offset", Integer.toString(offset));
		return doGetCheckins(userId, params); 
	}
	
	private CheckinInfo doGetCheckins(String userId, Map<String,String> params) {
		return get(buildUri(USERS_ENDPOINT + userId + "/checkins", params), CheckinInfoContainer.class).getCheckinInfo();
	}
	

	public Friends getFriends() {
		return getFriends(0, 0);
	}

	public Friends getFriends(int limit, int offset) {
		return getFriends("self", limit, offset);
	}

	public Friends getFriends(String userId) {
		return getFriends(userId, 0, 0);
	}
    
	public Friends getFriends(String userId, int limit, int offset) {
		Map<String,String> params = new HashMap<String,String>();
		if(limit > 0) {
			params.put("limit", Integer.toString(limit));
		}
		if(offset > 0) {
			params.put("offset", Integer.toString(offset));
		}
		return get(buildUri(USERS_ENDPOINT + userId + "/friends", params), FriendsContainer.class).getFriends();
	}

	public Tips getRecentTips(int limit, int offset) {
		return getRecentTips("self", limit, offset);
	}

	public Tips getRecentTips(String userId, int limit, int offset) {
		return doTips(userId, "recent", null, null, limit, offset);
	}

	public Tips getPopularTips(int limit, int offset) {
		return getPopularTips("self", limit, offset);
	}

	public Tips getPopularTips(String userId, int limit, int offset) {
		return doTips(userId, "popular", null, null, limit, offset);
	}

	public Tips getNearbyTips(double latitude, double longitude, int limit, int offset) {
		return getNearbyTips("self", latitude, longitude, limit, offset);
	}
	
	public Tips getNearbyTips(String userId, double latitude, double longitude, int limit, int offset) {
		return doTips(userId, "nearby", new Double(latitude), new Double(longitude), limit, offset);
	}
	
	private Tips doTips(String userId, String sort, Double latitude, Double longitude, int limit, int offset) {
		requireUserAuthorization();
		Map<String,String> params = new HashMap<String,String>();
		params.put("sort", sort);
		if(latitude != null && longitude != null) {
			params.put("ll", latitude.toString() + "," + longitude.toString());
		}
		if(limit > 0) {
			params.put("limit", Integer.toString(limit));
		}
		if(offset > 0) {
			params.put("offset", Integer.toString(offset));
		}
		return get(buildUri(USERS_ENDPOINT + userId + "/tips", params), TipsContainer.class).getTips();
	}

	public Todos getRecentTodos() {
		return getRecentTodos("self");
	}

	public Todos getRecentTodos(String userId) {
		return doTodos(userId, "recent", null, null);
	}

	public Todos getNearbyTodos(double latitude, double longitude) {
		return getNearbyTodos("self", latitude, longitude);
	}
	
	public Todos getNearbyTodos(String userId, double latitude, double longitude) {
		return doTodos(userId, "nearby", new Double(latitude), new Double(longitude));
	}

	public Todos getPopularTodos(String userId) {
		return doTodos(userId, "popular", null, null);
	}

	public Todos getPopularTodos() {
		return getPopularTodos("self");
	}
	
	private Todos doTodos(String userId, String sort, Double latitude, Double longitude) {
		Map<String,String> params = new HashMap<String,String>();
		params.put("sort", sort);
		if(latitude != null && longitude != null) {
			params.put("ll", latitude.toString() + "," + longitude.toString());
		}
		return get(buildUri(USERS_ENDPOINT + userId + "/todos", params), TodosContainer.class).getTodos();
	}

	public VenueHistory getVenueHistory(long beforeTimestamp, long afterTimestamp, String categoryId) {
		return getVenueHistory("self", beforeTimestamp, afterTimestamp, categoryId);
	}

	public VenueHistory getVenueHistory(String userId, long beforeTimestamp, long afterTimestamp, String categoryId) {
		requireUserAuthorization();
		Map<String,String> params = new HashMap<String,String>();
		if(beforeTimestamp > 0) {
			params.put("beforeTimestamp", Long.toString(beforeTimestamp));
		}
		if(afterTimestamp > 0) {
			params.put("afterTimestamp", Long.toString(afterTimestamp));
		}
		if(categoryId != null) {
			params.put("categoryId", categoryId);
		}
		return get(buildUri(USERS_ENDPOINT + userId + "/venuehistory", params), VenueHistoryContainer.class).getVenueHistory();
	}

	public void requestFriend(String userId) {
		requireUserAuthorization();
		post(buildUri(USERS_ENDPOINT + userId + "/request"), new LinkedMultiValueMap<String, Object>(), Map.class);
	}

	public void removeFriend(String userId) {
		requireUserAuthorization();
		post(buildUri(USERS_ENDPOINT + userId + "/unfriend"), new LinkedMultiValueMap<String, Object>(), Map.class);
	}

	public void approveFriend(String userId) {
		requireUserAuthorization();
		post(buildUri(USERS_ENDPOINT + userId + "/approve"), new LinkedMultiValueMap<String, Object>(), Map.class);
	}

	public void denyFriend(String userId) {
		requireUserAuthorization();
		post(buildUri(USERS_ENDPOINT + userId + "/deny"), new LinkedMultiValueMap<String, Object>(), Map.class);
	}

	public void setPings(String userId, boolean value) {
		requireUserAuthorization();
		MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
		params.add("value", Boolean.toString(value));
		post(buildUri(USERS_ENDPOINT + userId + "/setpings"), params, Map.class);
	}
}
