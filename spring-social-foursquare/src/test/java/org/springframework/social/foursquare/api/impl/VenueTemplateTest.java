package org.springframework.social.foursquare.api.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
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
import org.springframework.social.foursquare.api.CheckinInfo;
import org.springframework.social.foursquare.api.ExploreQuery;
import org.springframework.social.foursquare.api.ExploreResponse;
import org.springframework.social.foursquare.api.Location;
import org.springframework.social.foursquare.api.Tips;
import org.springframework.social.foursquare.api.Todo;
import org.springframework.social.foursquare.api.Venue;
import org.springframework.social.foursquare.api.VenueLinks;
import org.springframework.social.foursquare.api.Photos;
import org.springframework.social.foursquare.api.VenueSearchParams;

public class VenueTemplateTest extends AbstractFoursquareApiTest {
	
	@Test
	public void getVenue() {
		mockServer.expect(requestTo("https://api.foursquare.com/v2/venues/VENUE_ID?oauth_token=ACCESS_TOKEN&v=20110609"))
			.andExpect(method(GET))
			.andRespond(withResponse(new ClassPathResource("testdata/venue.json", getClass()), responseHeaders));
		
		Venue venue = foursquare.venueOperations().getVenue("VENUE_ID");
		assertEquals("3fd66200f964a520dbe91ee3", venue.getId());
		Location location = venue.getLocation();
		assertNotNull(location);
		assertEquals("170 Thompson St", location.getAddress());
		assertEquals("btwn Bleecker & Houston", location.getCrossStreet());
		assertEquals("NY", location.getState());
		assertEquals("New York", location.getCity());
		assertEquals("10012", location.getPostalCode());
		assertEquals("USA", location.getCountry());
		assertEquals(40.7276468d, location.getLatitude(), 0d);
		assertEquals(-74.0002398, location.getLongitude(), 0d);
		mockServer.verify();
	}
	
	@Test
	public void addVenue() {
		mockServer.expect(requestTo("https://api.foursquare.com/v2/venues/add?oauth_token=ACCESS_TOKEN&v=20110609"))
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
		mockServer.expect(requestTo("https://api.foursquare.com/v2/venues/categories?oauth_token=ACCESS_TOKEN&v=20110609"))
			.andExpect(method(GET))
			.andRespond(withResponse(new ClassPathResource("testdata/categories.json", getClass()), responseHeaders));
		
		List<Category> categories = foursquare.venueOperations().getCategories();
		assertTrue(categories.size() > 0);
	}
	
	@Test
    public void explore() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/venues/explore?oauth_token=ACCESS_TOKEN&v=20110609&ll=10.0%2C10.0&query=QUERY"))
            .andExpect(method(GET))
            .andRespond(withResponse(new ClassPathResource("testdata/explore.json", getClass()), responseHeaders));
        
        ExploreQuery query = new ExploreQuery().location(10d, 10d).query("QUERY");
        ExploreResponse response = foursquare.venueOperations().explore(query);
        assertEquals(30, response.getKeywords().getCount());
    }
	
	@Test
    public void search() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/venues/search?oauth_token=ACCESS_TOKEN&v=20110609&ll=10.0%2C10.0&query=QUERY"))
            .andExpect(method(GET))
            .andRespond(withResponse(new ClassPathResource("testdata/venue-search.json", getClass()), responseHeaders));
        
        VenueSearchParams query = new VenueSearchParams().location(10d, 10d).query("QUERY");
        List<Venue> results = foursquare.venueOperations().search(query);
        assertTrue(results.size() > 0);
    }
	
	@Test
    public void getTrending() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/venues/trending?oauth_token=ACCESS_TOKEN&v=20110609&ll=10.0%2C10.0&radius=100"))
            .andExpect(method(GET))
            .andRespond(withResponse(new ClassPathResource("testdata/trending.json", getClass()), responseHeaders));
        
        List<Venue> results = foursquare.venueOperations().getTrending(10d, 10d, 100, 0);
        assertTrue(results.size() > 0);
    }
	
	@Test
    public void getHereNow() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/venues/VENUE_ID/herenow?oauth_token=ACCESS_TOKEN&v=20110609"))
            .andExpect(method(GET))
            .andRespond(withResponse(new ClassPathResource("testdata/herenow.json", getClass()), responseHeaders));
        
        CheckinInfo herenow = foursquare.venueOperations().getHereNow("VENUE_ID", 0, 0, 0);
        assertTrue(herenow.getCheckins().size() > 0);
    }
	
	@Test
    public void getTips() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/venues/VENUE_ID/tips?oauth_token=ACCESS_TOKEN&v=20110609&sort=popular"))
            .andExpect(method(GET))
            .andRespond(withResponse(new ClassPathResource("testdata/tips.json", getClass()), responseHeaders));
        
        Tips tips = foursquare.venueOperations().getTips("VENUE_ID", null, 0, 0);
        assertTrue(tips.getItems().size() > 0);
    }
	
	@Test
    public void getPhotos() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/venues/VENUE_ID/photos?oauth_token=ACCESS_TOKEN&v=20110609&group=venue"))
            .andExpect(method(GET))
            .andRespond(withResponse(new ClassPathResource("testdata/venuephotos.json", getClass()), responseHeaders));
        
        Photos photos = foursquare.venueOperations().getPhotos("VENUE_ID", null, 0, 0);
        assertTrue(photos.getItems().size() > 0);
    }
	
	@Test
    public void getLinks() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/venues/VENUE_ID/links?oauth_token=ACCESS_TOKEN&v=20110609"))
            .andExpect(method(GET))
            .andRespond(withResponse(new ClassPathResource("testdata/venuelinks.json", getClass()), responseHeaders));
        
        VenueLinks links = foursquare.venueOperations().getLinks("VENUE_ID");
        assertTrue(links.getItems().size() > 0);
    }
	
	@Test
    public void markTodo() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/venues/VENUE_ID/marktodo?oauth_token=ACCESS_TOKEN&v=20110609"))
            .andExpect(method(POST))
            .andExpect(body("text=TEXT"))
            .andRespond(withResponse(new ClassPathResource("testdata/marktodo.json", getClass()), responseHeaders));
        
        Todo todo = foursquare.venueOperations().markTodo("VENUE_ID", "TEXT");
        assertTrue(todo != null);
    }
	
	@Test
    public void flag() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/venues/VENUE_ID/flag?oauth_token=ACCESS_TOKEN&v=20110609"))
            .andExpect(method(POST))
            .andExpect(body("problem=closed"))
            .andRespond(withResponse(new ClassPathResource("testdata/ok-response.json", getClass()), responseHeaders));
        
        foursquare.venueOperations().flag("VENUE_ID", "closed");
    }
	
	@Test
    public void edit() {
		mockServer.expect(requestTo("https://api.foursquare.com/v2/venues/VENUE_ID/edit?oauth_token=ACCESS_TOKEN&v=20110609"))
		.andExpect(method(POST))
		.andExpect(body("name=NAME&address=ADDRESS&crossStreet=CROSSSTREET&city=CITY&state=STATE&zip=ZIP&phone=PHONE&ll=1.0%2C1.0&categoryId=CATEGORYID"))
		.andRespond(withResponse(new ClassPathResource("testdata/ok-response.json", getClass()), responseHeaders));
		
		foursquare.venueOperations().edit("VENUE_ID", "NAME", "ADDRESS", "CROSSSTREET", "CITY", "STATE", "ZIP", "PHONE", 1, 1, "CATEGORYID");
		mockServer.verify();
    }
	
	@Test
    public void proposeEdit() {
		mockServer.expect(requestTo("https://api.foursquare.com/v2/venues/VENUE_ID/proposeedit?oauth_token=ACCESS_TOKEN&v=20110609"))
		.andExpect(method(POST))
		.andExpect(body("name=NAME&address=ADDRESS&crossStreet=CROSSSTREET&city=CITY&state=STATE&zip=ZIP&phone=PHONE&ll=1.0%2C1.0&primaryCategoryId=CATEGORYID"))
		.andRespond(withResponse(new ClassPathResource("testdata/ok-response.json", getClass()), responseHeaders));
		
		foursquare.venueOperations().proposeEdit("VENUE_ID", "NAME", "ADDRESS", "CROSSSTREET", "CITY", "STATE", "ZIP", "PHONE", 1, 1, "CATEGORYID");
		mockServer.verify();
    }
}
