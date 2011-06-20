package org.springframework.social.foursquare.api.impl;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpMethod.GET;
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
import org.springframework.social.foursquare.api.UserSearchResponse;

public class UserTemplateTest extends AbstractFoursquareApiTest {
	
    @Test
	public void getUser() {
		mockServer.expect(requestTo("https://api.foursquare.com/v2/users/self/?access_token=ACCESS_TOKEN"))
			.andExpect(method(GET))
			.andRespond(withResponse(new ClassPathResource("testdata/user-profile.json", getClass()), responseHeaders));
		
		FoursquareUser user = foursquare.userOperations().getUser();
		mockServer.verify();
		assertProfile(user);
	}
    
    @Test
    public void getLeaderboard() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/users/leaderboard/?access_token=ACCESS_TOKEN"))
            .andExpect(method(GET))
            .andRespond(withResponse(new ClassPathResource("testdata/leaderboard.json", getClass()), responseHeaders));
        
        Leaderboard leaderboard = foursquare.userOperations().getLeaderboard();
        mockServer.verify();
        assertEquals(23, leaderboard.getCount());
    }
    
    @Test
    public void searchWithParameters() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/users/search/?access_token=ACCESS_TOKEN&twitter=matt&phone=123&email=john%40doe.com&fbid=321"))
            .andExpect(method(GET))
            .andRespond(withResponse(new ClassPathResource("testdata/user-search.json", getClass()), responseHeaders));
        
        UserSearchResponse results = foursquare.userOperations().search(Arrays.asList("123"),
                Arrays.asList("john@doe.com"), Arrays.asList("matt"), Arrays.asList("321"));
        
        assertEquals(3, results.getResults().size());
        mockServer.verify();
    }
    
    @Test
    public void searchName() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/users/search/?access_token=ACCESS_TOKEN&name=matt"))
            .andExpect(method(GET))
            .andRespond(withResponse(new ClassPathResource("testdata/user-search.json", getClass()), responseHeaders));
        
        UserSearchResponse results = foursquare.userOperations().searchByName("matt");
        assertEquals(3, results.getResults().size());
        mockServer.verify();
    }
    
    @Test
    public void searchTwitterFriends() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/users/search/?access_token=ACCESS_TOKEN&twitterSource=matt"))
            .andExpect(method(GET))
            .andRespond(withResponse(new ClassPathResource("testdata/user-search.json", getClass()), responseHeaders));
        
        UserSearchResponse results = foursquare.userOperations().searchTwitterFriends("matt");
        assertEquals(3, results.getResults().size());
        mockServer.verify();
    }
    
    @Test
    public void getRequests() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/users/requests/?access_token=ACCESS_TOKEN"))
            .andExpect(method(GET))
            .andRespond(withResponse(new ClassPathResource("testdata/requests.json", getClass()), responseHeaders));
        
        List<FoursquareUser> requests = foursquare.userOperations().getRequests();
        assertEquals(3, requests.size());
        mockServer.verify();
    }
    
    @Test
    public void getBadges() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/users/self/badges/?access_token=ACCESS_TOKEN"))
            .andExpect(method(GET))
            .andRespond(withResponse(new ClassPathResource("testdata/badges.json", getClass()), responseHeaders));
        
        BadgesResponse response = foursquare.userOperations().getBadges();
        assertEquals("#4sqDay 2010", response.getBadges().get("4bc8d78d675403bb8f466094").getName());
        mockServer.verify();
    }
    
    @Test
    public void getCheckins() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/users/self/checkins/?access_token=ACCESS_TOKEN"))
            .andExpect(method(GET))
            .andRespond(withResponse(new ClassPathResource("testdata/checkins.json", getClass()), responseHeaders));
        
        CheckinInfo checkinInfo = foursquare.userOperations().getCheckins();
        assertEquals(562, checkinInfo.getTotal());
        mockServer.verify();
    }
    
    @Test
    public void getFriends() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/users/self/friends/?access_token=ACCESS_TOKEN"))
            .andExpect(method(GET))
            .andRespond(withResponse(new ClassPathResource("testdata/friends.json", getClass()), responseHeaders));
        
        Friends friends = foursquare.userOperations().getFriends();
        assertEquals(6, friends.getCount());
        assertEquals(6, friends.getItems().size());
        mockServer.verify();
    }
    
    @Test
    public void getTips() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/users/self/tips/?access_token=ACCESS_TOKEN&sort=recent"))
            .andExpect(method(GET))
            .andRespond(withResponse(new ClassPathResource("testdata/tips.json", getClass()), responseHeaders));
        
        Tips tips = foursquare.userOperations().getRecentTips(0, 0);
        assertEquals(3, tips.getCount());
        mockServer.verify();
    }
}
