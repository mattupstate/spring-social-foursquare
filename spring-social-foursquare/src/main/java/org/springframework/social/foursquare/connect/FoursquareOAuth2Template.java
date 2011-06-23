package org.springframework.social.foursquare.connect;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class FoursquareOAuth2Template extends OAuth2Template {

    public FoursquareOAuth2Template(String clientId, String clientSecret) {
        super(clientId, clientSecret, "https://foursquare.com/oauth2/authenticate", "https://foursquare.com/oauth2/access_token");
    }
    
    @Override
    protected RestTemplate createRestTemplate() {
        RestTemplate restTemplate = new RestTemplate(ClientHttpRequestFactorySelector.getRequestFactory());
        FormHttpMessageConverter messageConverter = new FormHttpMessageConverter() {
            public boolean canRead(Class<?> clazz, MediaType mediaType) {
                return true;
            }
        };
        restTemplate.setMessageConverters(Collections.<HttpMessageConverter<?>>singletonList(messageConverter));
        return restTemplate;
    }
    
    @Override
    @SuppressWarnings("unchecked")  
    protected AccessGrant postForAccessGrant(String accessTokenUrl, MultiValueMap<String, String> parameters) {
    	Map<String,Object> response = getRestTemplate().postForObject(accessTokenUrl, parameters, Map.class);
    	Entry<String,Object> entry = response.entrySet().iterator().next();
		String jsonString = entry.getKey();
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> response2 = null;
		try {
			response2 = mapper.readValue(jsonString, Map.class);
		} catch (Exception e) {
			
		}
        return new AccessGrant(response2.get("access_token"), null, null, null);
    }
}
