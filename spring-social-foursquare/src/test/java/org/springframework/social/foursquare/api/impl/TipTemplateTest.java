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
import org.springframework.social.foursquare.api.Tip;
import org.springframework.social.foursquare.api.Todo;

public class TipTemplateTest extends AbstractFoursquareApiTest {
	
	@Test
	public void get() {
		mockServer.expect(requestTo("https://api.foursquare.com/v2/tips/TIP_ID?oauth_token=ACCESS_TOKEN&v=20110609"))
			.andExpect(method(GET))
			.andRespond(withResponse(new ClassPathResource("testdata/tip.json", getClass()), responseHeaders));
		
		Tip tip = foursquare.tipOperations().get("TIP_ID");
		assertEquals("4b5e662a70c603bba7d790b4", tip.getId());
		mockServer.verify();
	}
	
	@Test
	public void add() {
		mockServer.expect(requestTo("https://api.foursquare.com/v2/tips/add?oauth_token=ACCESS_TOKEN&v=20110609"))
			.andExpect(method(POST))
			.andExpect(body("venueId=VENUE_ID&text=TEXT&url=URL"))
			.andRespond(withResponse(new ClassPathResource("testdata/tip.json", getClass()), responseHeaders));
		
		Tip tip = foursquare.tipOperations().add("VENUE_ID", "TEXT", "URL");
		assertEquals("4b5e662a70c603bba7d790b4", tip.getId());
		mockServer.verify();
	}
	
	@Test
	public void search() {
		mockServer.expect(requestTo("https://api.foursquare.com/v2/tips/search?oauth_token=ACCESS_TOKEN&v=20110609&ll=10.0%2C10.0&query=QUERY&offset=10&filter=friends"))
			.andExpect(method(GET))
			.andRespond(withResponse(new ClassPathResource("testdata/searchtips.json", getClass()), responseHeaders));
		
		List<Tip> tips = foursquare.tipOperations().search(10d, 10d, "QUERY", 10, true);
		assertTrue(tips.size() > 0);
		mockServer.verify();
	}
	
	@Test
	public void markTodo() {
		mockServer.expect(requestTo("https://api.foursquare.com/v2/tips/TIP_ID/marktodo?oauth_token=ACCESS_TOKEN&v=20110609"))
			.andExpect(method(POST))
			.andRespond(withResponse(new ClassPathResource("testdata/marktodo.json", getClass()), responseHeaders));
		
		Todo todo = foursquare.tipOperations().markTodo("TIP_ID");
		assertTrue(todo != null);
		mockServer.verify();
	}
	
	@Test
	public void markDone() {
		mockServer.expect(requestTo("https://api.foursquare.com/v2/tips/TIP_ID/markdone?oauth_token=ACCESS_TOKEN&v=20110609"))
			.andExpect(method(POST))
			.andRespond(withResponse(new ClassPathResource("testdata/marktodo.json", getClass()), responseHeaders));
		
		Todo todo = foursquare.tipOperations().markDone("TIP_ID");
		assertTrue(todo != null);
		mockServer.verify();
	}
	
	@Test
	public void unmark() {
		mockServer.expect(requestTo("https://api.foursquare.com/v2/tips/TIP_ID/unmark?oauth_token=ACCESS_TOKEN&v=20110609"))
			.andExpect(method(POST))
			.andRespond(withResponse(new ClassPathResource("testdata/tip.json", getClass()), responseHeaders));
		
		Tip tip = foursquare.tipOperations().unmarkTodo("TIP_ID");
		assertTrue(tip != null);
		mockServer.verify();
	}
}
