package org.springframework.social.foursquare.api.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.social.foursquare.api.FoursquareUser;
import org.springframework.social.test.client.MockRestServiceServer;

public class AbstractFoursquareApiTest {

	public FoursquareTemplate foursquare;
	
	protected MockRestServiceServer mockServer;

	protected HttpHeaders responseHeaders;
	
	@Before
	public void setup() {
		foursquare = new FoursquareTemplate("CLIENT_ID", "CLIENT_SECRET", "ACCESS_TOKEN");
		mockServer = MockRestServiceServer.createServer(foursquare.getRestTemplate());
		responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
	}
	
	public void assertProfile(FoursquareUser profile) {
		assertEquals("Matt", profile.getFirstName());
		assertEquals("Wright", profile.getLastName());
		assertEquals("male", profile.getGender());
		assertEquals(3, profile.getMayorshipInfo().getTotal());
		assertEquals(659, profile.getCheckinInfo().getTotal());
		assertEquals("https://playfoursquare.s3.amazonaws.com/userpix_thumbs/OGGQATTYHOGWJL4E.jpg", profile.getPhotoUrl());
	}
}
