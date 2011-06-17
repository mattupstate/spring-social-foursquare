package org.springframework.social.foursquare.api.impl.json;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.foursquare.api.FriendGroup;

@JsonIgnoreProperties(ignoreUnknown=true)
public class FriendGroupList {

	private List<FriendGroup> list;
	
	public FriendGroupList(@JsonProperty("groups") List<FriendGroup> list) {
		this.list = list;
	}
	
	public List<FriendGroup> getList() {
		return list;
	}
	
}
