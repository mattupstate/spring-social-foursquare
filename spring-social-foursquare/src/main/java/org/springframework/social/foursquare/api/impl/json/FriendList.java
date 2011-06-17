package org.springframework.social.foursquare.api.impl.json;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.foursquare.api.FoursquareUser;

@JsonIgnoreProperties(ignoreUnknown=true)
public class FriendList {
	
	private List<FoursquareUser> list;
	
	public FriendList(@JsonProperty("items") List<FoursquareUser> list) {
		this.list = list;
	}
	
	public List<FoursquareUser> getList() {
		return list;
	}
}
