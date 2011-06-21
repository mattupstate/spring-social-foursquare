package org.springframework.social.foursquare.api.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.social.test.client.RequestMatchers.body;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

import java.util.List;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.social.foursquare.api.Category;
import org.springframework.social.foursquare.api.ExploreQuery;
import org.springframework.social.foursquare.api.ExploreResponse;
import org.springframework.social.foursquare.api.Venue;
import org.springframework.social.foursquare.api.VenueSearchQuery;

public class VenueTemplateTest extends AbstractFoursquareApiTest {
	@Test
	public void getVenue() {
		mockServer.expect(requestTo("https://api.foursquare.com/v2/venues/VENUE_ID/?access_token=ACCESS_TOKEN&v=20110608"))
			.andExpect(method(GET))
			.andRespond(withResponse(new ClassPathResource("testdata/venue.json", getClass()), responseHeaders));
		
		Venue venue = foursquare.venueOperations().getVenue("VENUE_ID");
		assertEquals("3fd66200f964a520dbe91ee3", venue.getId());
		mockServer.verify();
	}
	
	@Test
	public void addVenue() {
		mockServer.expect(requestTo("https://api.foursquare.com/v2/venues/add/?access_token=ACCESS_TOKEN&v=20110608"))
			.andExpect(method(POST))
			.andExpect(body("name=NAME&address=ADDRESS&crossStreet=CROSSSTREET&city=CITY&state=STATE&zip=ZIP&phone=PHONE&ll=1.0%2C1.0&primaryCategoryId=CATEGORYID"))
			.andRespond(withResponse(new ClassPathResource("testdata/venue.json", getClass()), responseHeaders));
		
		Venue venue = foursquare.venueOperations().addVenue( "NAME", "ADDRESS", "CROSSSTREET",
				"CITY", "STATE", "ZIP", "PHONE", 1, 1, "CATEGORYID");
		assertEquals("3fd66200f964a520dbe91ee3", venue.getId());
		mockServer.verify();
	}
	
	@Test
	public void getCateogies() {
		mockServer.expect(requestTo("https://api.foursquare.com/v2/venues/categories/?access_token=ACCESS_TOKEN&v=20110608"))
			.andExpect(method(GET))
			.andRespond(withResponse(new ClassPathResource("testdata/categories.json", getClass()), responseHeaders));
		
		List<Category> categories = foursquare.venueOperations().getCategories();
		assertTrue(categories.size() > 0);
	}
	
	@Test
    public void explore() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/venues/explore/?access_token=ACCESS_TOKEN&v=20110608&ll=10.0%2C10.0&query=QUERY"))
            .andExpect(method(GET))
            .andRespond(withResponse(new ClassPathResource("testdata/explore.json", getClass()), responseHeaders));
        
        ExploreQuery query = new ExploreQuery().location(10d, 10d).query("QUERY");
        ExploreResponse response = foursquare.venueOperations().explore(query);
        assertEquals(30, response.getKeywords().getCount());
    }
	
	@Test
    public void search() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/venues/search/?access_token=ACCESS_TOKEN&v=20110608&ll=10.0%2C10.0&query=QUERY"))
            .andExpect(method(GET))
            .andRespond(withResponse(new ClassPathResource("testdata/venue-search.json", getClass()), responseHeaders));
        
        VenueSearchQuery query = new VenueSearchQuery().location(10d, 10d).query("QUERY");
        List<Venue> results = foursquare.venueOperations().search(query);
        assertTrue(results.size() > 0);
    }
	
	@Test
    public void getTrending() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/venues/trending/?access_token=ACCESS_TOKEN&v=20110608&ll=10.0%2C10.0&radius=100"))
            .andExpect(method(GET))
            .andRespond(withResponse(new ClassPathResource("testdata/trending.json", getClass()), responseHeaders));
        
        List<Venue> results = foursquare.venueOperations().getTrending(10d, 10d, 100, 0);
        assertTrue(results.size() > 0);
    }
}
