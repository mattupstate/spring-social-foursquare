package org.springframework.social.foursquare.api.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.social.test.client.RequestMatchers.body;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.social.foursquare.api.AllSettings;

public class SettingTemplateTest extends AbstractFoursquareApiTest {

	@Test
	public void getAll() {
		mockServer.expect(requestTo("https://api.foursquare.com/v2/settings/all?oauth_token=ACCESS_TOKEN&v=20110609"))
			.andExpect(method(GET))
			.andRespond(withResponse(new ClassPathResource("testdata/allsettings.json", getClass()), responseHeaders));
		
		AllSettings settings = foursquare.settingOperations().getAll();
		assertTrue(settings.receivePings());
		mockServer.verify();
	}
	
	@Test
	public void getSetting() {
		mockServer.expect(requestTo("https://api.foursquare.com/v2/settings/SETTING_ID?oauth_token=ACCESS_TOKEN&v=20110609"))
			.andExpect(method(GET))
			.andRespond(withResponse(new ClassPathResource("testdata/booleansetting.json", getClass()), responseHeaders));
		
		Boolean setting = foursquare.settingOperations().getSetting("SETTING_ID");
		assertTrue(setting);
		mockServer.verify();
	}
	
	@Test
	public void setSetting() {
		mockServer.expect(requestTo("https://api.foursquare.com/v2/settings/SETTING_ID/set?oauth_token=ACCESS_TOKEN&v=20110609"))
			.andExpect(method(POST))
			.andExpect(body("value=1"))
			.andRespond(withResponse(new ClassPathResource("testdata/setsetting.json", getClass()), responseHeaders));
		
		String msg = foursquare.settingOperations().setSetting("SETTING_ID", true);
		assertEquals("done", msg);
		mockServer.verify();
	}
	
}
