package org.springframework.social.foursquare.api.impl;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.social.foursquare.api.Special;
import org.springframework.social.foursquare.api.Specials;

public class SpecialTemplateTest extends AbstractFoursquareApiTest {

	@Test
	public void get() {
		mockServer.expect(requestTo("https://api.foursquare.com/v2/specials/SPECIAL_ID?oauth_token=ACCESS_TOKEN&v=20110609&venueId=VENUE_ID"))
			.andExpect(method(GET))
			.andRespond(withResponse(new ClassPathResource("testdata/special.json", getClass()), responseHeaders));
		
		Special special = foursquare.specialOperations().get("SPECIAL_ID", "VENUE_ID");
		assertEquals("4cfc5c5ffabc2d437522ddd2", special.getId());
		mockServer.verify();
	}
	
	@Test
	public void search() {
		mockServer.expect(requestTo("https://api.foursquare.com/v2/specials/search?oauth_token=ACCESS_TOKEN&v=20110609&limit=10&ll=10.0%2C10.0&alt=10.0&altAcc=100&llAcc=100"))
			.andExpect(method(GET))
			.andRespond(withResponse(new ClassPathResource("testdata/searchspecials.json", getClass()), responseHeaders));
		
		Specials specials = foursquare.specialOperations().search(10d, 10d, 100l, 10d, 100l, 10);
		assertEquals(30, specials.getCount());
		mockServer.verify();
	}
	
}
