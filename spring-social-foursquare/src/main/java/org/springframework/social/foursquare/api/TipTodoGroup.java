package org.springframework.social.foursquare.api;

import java.util.List;

public class TipTodoGroup {
	
	private int count;
	private List<TipUserGroup> groups;
	
	public TipTodoGroup(int count, List<TipUserGroup> groups) {
		this.count = count;
		this.groups = groups;
	}

	public int getCount() {
		return count;
	}

	public List<TipUserGroup> getGroups() {
		return groups;
	}
}
