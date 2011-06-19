package org.springframework.social.foursquare.api.impl;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.social.foursquare.api.FoursquareUser;
import org.springframework.social.foursquare.api.Leaderboard;

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
    
	
}
