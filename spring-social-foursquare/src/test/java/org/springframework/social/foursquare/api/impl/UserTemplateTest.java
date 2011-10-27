package org.springframework.social.foursquare.api.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.social.test.client.RequestMatchers.body;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.social.foursquare.api.BadgesResponse;
import org.springframework.social.foursquare.api.CheckinInfo;
import org.springframework.social.foursquare.api.FoursquareUser;
import org.springframework.social.foursquare.api.Friends;
import org.springframework.social.foursquare.api.Leaderboard;
import org.springframework.social.foursquare.api.Tips;
import org.springframework.social.foursquare.api.Todos;
import org.springframework.social.foursquare.api.UserSearchResponse;
import org.springframework.social.foursquare.api.VenueHistory;

public class UserTemplateTest extends AbstractFoursquareApiTest {
	
    @Test
	public void getUser() {
		mockServer.expect(requestTo("https://api.foursquare.com/v2/users/self?oauth_token=ACCESS_TOKEN&v=20110609"))
			.andExpect(method(GET))
			.andRespond(withResponse(new ClassPathResource("testdata/user-profile.json", getClass()), responseHeaders));
		
		FoursquareUser user = foursquare.userOperations().getUser();
		mockServer.verify();
		assertProfile(user);
	}
    
    @Test
    public void getLeaderboard() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/users/leaderboard?oauth_token=ACCESS_TOKEN&v=20110609"))
            .andExpect(method(GET))
            .andRespond(withResponse(new ClassPathResource("testdata/leaderboard.json", getClass()), responseHeaders));
        
        Leaderboard leaderboard = foursquare.userOperations().getLeaderboard();
        mockServer.verify();
        assertEquals(23, leaderboard.getCount());
    }
    
    @Test
    public void searchWithParameters() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/users/search?oauth_token=ACCESS_TOKEN&v=20110609&twitter=matt&phone=123&email=john%40doe.com&fbid=321"))
            .andExpect(method(GET))
            .andRespond(withResponse(new ClassPathResource("testdata/user-search.json", getClass()), responseHeaders));
        
        UserSearchResponse results = foursquare.userOperations().search(Arrays.asList("123"),
                Arrays.asList("john@doe.com"), Arrays.asList("matt"), Arrays.asList("321"));
        
        assertEquals(3, results.getResults().size());
        mockServer.verify();
    }
    
    @Test
    public void searchName() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/users/search?oauth_token=ACCESS_TOKEN&v=20110609&name=matt"))
            .andExpect(method(GET))
            .andRespond(withResponse(new ClassPathResource("testdata/user-search.json", getClass()), responseHeaders));
        
        UserSearchResponse results = foursquare.userOperations().searchByName("matt");
        assertEquals(3, results.getResults().size());
        mockServer.verify();
    }
    
    @Test
    public void searchTwitterFriends() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/users/search?oauth_token=ACCESS_TOKEN&v=20110609&twitterSource=matt"))
            .andExpect(method(GET))
            .andRespond(withResponse(new ClassPathResource("testdata/user-search.json", getClass()), responseHeaders));
        
        UserSearchResponse results = foursquare.userOperations().searchTwitterFriends("matt");
        assertEquals(3, results.getResults().size());
        mockServer.verify();
    }
    
    @Test
    public void getRequests() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/users/requests?oauth_token=ACCESS_TOKEN&v=20110609"))
            .andExpect(method(GET))
            .andRespond(withResponse(new ClassPathResource("testdata/requests.json", getClass()), responseHeaders));
        
        List<FoursquareUser> requests = foursquare.userOperations().getRequests();
        assertEquals(3, requests.size());
        mockServer.verify();
    }
    
    @Test
    public void getBadges() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/users/self/badges?oauth_token=ACCESS_TOKEN&v=20110609"))
            .andExpect(method(GET))
            .andRespond(withResponse(new ClassPathResource("testdata/badges.json", getClass()), responseHeaders));
        
        BadgesResponse response = foursquare.userOperations().getBadges();
        assertEquals("#4sqDay 2010", response.getBadges().get("4bc8d78d675403bb8f466094").getName());
        mockServer.verify();
    }
    
    @Test
    public void getCheckins() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/users/self/checkins?oauth_token=ACCESS_TOKEN&v=20110609"))
            .andExpect(method(GET))
            .andRespond(withResponse(new ClassPathResource("testdata/checkins.json", getClass()), responseHeaders));
        
        CheckinInfo checkinInfo = foursquare.userOperations().getCheckins();
        assertEquals(562, checkinInfo.getTotal());
        assertTrue(checkinInfo.getCheckins().get(0) != null);
        mockServer.verify();
    }
    
    @Test
    public void getCheckinsWithOffset() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/users/self/checkins?oauth_token=ACCESS_TOKEN&v=20110609&limit=100&offset=50"))
            .andExpect(method(GET))
            .andRespond(withResponse(new ClassPathResource("testdata/checkins.json", getClass()), responseHeaders));
        
        CheckinInfo checkinInfo = foursquare.userOperations().getCheckins(100, 50);
        assertTrue(checkinInfo.getCheckins().get(0) != null);
        mockServer.verify();
    }
    
    @Test
    public void getCheckinsWithTimestamps() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/users/self/checkins?oauth_token=ACCESS_TOKEN&v=20110609&limit=100&afterTimestamp=600&beforeTimestamp=500&offset=50"))
            .andExpect(method(GET))
            .andRespond(withResponse(new ClassPathResource("testdata/checkins.json", getClass()), responseHeaders));
        
        CheckinInfo checkinInfo = foursquare.userOperations().getCheckins(500, 600, 100, 50);
        assertTrue(checkinInfo.getCheckins().get(0) != null);
        mockServer.verify();
    }
    
    @Test
    public void getFriends() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/users/self/friends?oauth_token=ACCESS_TOKEN&v=20110609"))
            .andExpect(method(GET))
            .andRespond(withResponse(new ClassPathResource("testdata/friends.json", getClass()), responseHeaders));
        
        Friends friends = foursquare.userOperations().getFriends();
        assertEquals(6, friends.getCount());
        assertEquals(6, friends.getItems().size());
        mockServer.verify();
    }
    
    @Test
    public void getTips() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/users/self/tips?oauth_token=ACCESS_TOKEN&v=20110609&sort=recent"))
            .andExpect(method(GET))
            .andRespond(withResponse(new ClassPathResource("testdata/tips.json", getClass()), responseHeaders));
        
        Tips tips = foursquare.userOperations().getRecentTips(0, 0);
        assertEquals(3, tips.getCount());
        assertTrue(tips.getItems().get(0) != null);
        mockServer.verify();
    }

    @Test
    public void getTodos() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/users/self/todos?oauth_token=ACCESS_TOKEN&v=20110609&sort=recent"))
            .andExpect(method(GET))
            .andRespond(withResponse(new ClassPathResource("testdata/todos.json", getClass()), responseHeaders));
        
        Todos todos = foursquare.userOperations().getRecentTodos();
        assertEquals(2, todos.getCount());
        assertTrue(todos.getItems().get(0) != null);
        assertTrue(todos.getItems().get(0).getTip() != null);
        mockServer.verify();
    }
    
    @Test
    public void getVenueHistory() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/users/self/venuehistory?oauth_token=ACCESS_TOKEN&v=20110609"))
            .andExpect(method(GET))
            .andRespond(withResponse(new ClassPathResource("testdata/venue-history.json", getClass()), responseHeaders));
        
        VenueHistory history = foursquare.userOperations().getVenueHistory(0, 0, null);
        assertEquals(163, history.getCount());
        assertEquals(1, history.getItems().get(0).getBeenHere());
        assertTrue(history.getItems().get(0).getVenue() != null);
        mockServer.verify();
    }
    
    @Test
    public void requestFriend() {
    	mockServer.expect(requestTo("https://api.foursquare.com/v2/users/USER_ID/request?oauth_token=ACCESS_TOKEN&v=20110609"))
	        .andExpect(method(POST))
	        .andRespond(withResponse(new ClassPathResource("testdata/ok-response.json", getClass()), responseHeaders));
    	
    	foursquare.userOperations().requestFriend("USER_ID");
    }
    
    @Test
    public void removeFriend() {
    	mockServer.expect(requestTo("https://api.foursquare.com/v2/users/USER_ID/unfriend?oauth_token=ACCESS_TOKEN&v=20110609"))
	        .andExpect(method(POST))
	        .andRespond(withResponse(new ClassPathResource("testdata/ok-response.json", getClass()), responseHeaders));
    	
    	foursquare.userOperations().removeFriend("USER_ID");
    }
    
    @Test
    public void approveFriend() {
    	mockServer.expect(requestTo("https://api.foursquare.com/v2/users/USER_ID/approve?oauth_token=ACCESS_TOKEN&v=20110609"))
	        .andExpect(method(POST))
	        .andRespond(withResponse(new ClassPathResource("testdata/ok-response.json", getClass()), responseHeaders));
    	
    	foursquare.userOperations().approveFriend("USER_ID");
    }
    
    @Test
    public void denyFriend() {
    	mockServer.expect(requestTo("https://api.foursquare.com/v2/users/USER_ID/deny?oauth_token=ACCESS_TOKEN&v=20110609"))
	        .andExpect(method(POST))
	        .andRespond(withResponse(new ClassPathResource("testdata/ok-response.json", getClass()), responseHeaders));
    	
    	foursquare.userOperations().denyFriend("USER_ID");
    }
    
    @Test
    public void setPings() {
    	mockServer.expect(requestTo("https://api.foursquare.com/v2/users/USER_ID/setpings?oauth_token=ACCESS_TOKEN&v=20110609"))
	        .andExpect(method(POST))
	        .andExpect(body("value=true"))
	        .andRespond(withResponse(new ClassPathResource("testdata/ok-response.json", getClass()), responseHeaders));
    	
    	foursquare.userOperations().setPings("USER_ID", true);
    }
}
