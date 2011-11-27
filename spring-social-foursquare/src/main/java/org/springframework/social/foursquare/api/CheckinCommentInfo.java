package org.springframework.social.foursquare.api;

import java.util.List;

public class CheckinCommentInfo {
	
	private int count;
	private List<CheckinComment> items;
	
	public CheckinCommentInfo(int count, List<CheckinComment> items) {
		this.count = count;
		this.items = items;
	}

	public int getCount() {
		return count;
	}

	public List<CheckinComment> getItems() {
		return items;
	}
}
