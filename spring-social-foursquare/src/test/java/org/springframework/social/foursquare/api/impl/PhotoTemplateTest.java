package org.springframework.social.foursquare.api.impl;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

import org.junit.Test;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.social.foursquare.api.Photo;

public class PhotoTemplateTest extends AbstractFoursquareApiTest {
	
	@Test
	public void get() {
		mockServer.expect(requestTo("https://api.foursquare.com/v2/photos/PHOTO_ID?oauth_token=ACCESS_TOKEN&v=20110609"))
			.andExpect(method(GET))
			.andRespond(withResponse(new ClassPathResource("testdata/photo.json", getClass()), responseHeaders));
		
		Photo photo = foursquare.photoOperations().get("PHOTO_ID");
		assertEquals("4d0fb8162d39a340637dc42b", photo.getId());
		mockServer.verify();
	}
	
	@Test
	public void addToCheckin() {
		mockServer.expect(requestTo("https://api.foursquare.com/v2/photos/add?oauth_token=ACCESS_TOKEN&v=20110609"))
			.andExpect(method(POST))
			.andRespond(withResponse(new ClassPathResource("testdata/photo.json", getClass()), responseHeaders));
		
		Photo photo = foursquare.photoOperations().addToCheckin("CHECKIN_ID", getUploadResource("image.jpg", "IMAGE DATA"), null, null, null, null, null, null);
		assertEquals("4d0fb8162d39a340637dc42b", photo.getId());
		mockServer.verify();
	}
	
	@Test
	public void addToTip() {
		mockServer.expect(requestTo("https://api.foursquare.com/v2/photos/add?oauth_token=ACCESS_TOKEN&v=20110609"))
			.andExpect(method(POST))
			.andRespond(withResponse(new ClassPathResource("testdata/photo.json", getClass()), responseHeaders));
		
		Photo photo = foursquare.photoOperations().addToTip("TIP_ID", getUploadResource("image.jpg", "IMAGE DATA"), null, null, null, null, null, null);
		assertEquals("4d0fb8162d39a340637dc42b", photo.getId());
		mockServer.verify();
	}
	
	@Test
	public void addToVenue() {
		mockServer.expect(requestTo("https://api.foursquare.com/v2/photos/add?oauth_token=ACCESS_TOKEN&v=20110609"))
			.andExpect(method(POST))
			.andRespond(withResponse(new ClassPathResource("testdata/photo.json", getClass()), responseHeaders));
		
		Photo photo = foursquare.photoOperations().addToVenue("VENUE_ID", getUploadResource("image.jpg", "IMAGE DATA"), null, null, null, null, null, null);
		assertEquals("4d0fb8162d39a340637dc42b", photo.getId());
		mockServer.verify();
	}
	
	private Resource getUploadResource(final String filename, String content) {
		Resource res = new ByteArrayResource(content.getBytes()) {
			public String getFilename() throws IllegalStateException {
				return filename;
			};
		};
		return res;
	}
}
