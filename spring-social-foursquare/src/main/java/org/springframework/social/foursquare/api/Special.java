package org.springframework.social.foursquare.api;

import java.util.List;

public class Special {
	
	private String id;
	private String type;
	private String message;
	private String description;
	private boolean unlocked;
	private String icon;
	private String title;
	private String state;
	private int progress;
	private String progressDescription;
	private int detail;
	private int target;
	private List<FoursquareUser> friendsHere;
	private String provider;
	private String redemption;
	
	public Special(String id, String type, String message, String description, boolean unlocked,
			String icon, String title, String state) {
		this.id = id;
		this.type = type;
		this.message = message;
		this.description = description;
		this.unlocked = unlocked;
		this.icon = icon;
		this.title = title;
		this.state = state;
	}
	
	public String getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public String getMessage() {
		return message;
	}

	public String getDescription() {
		return description;
	}

	public boolean isUnlocked() {
		return unlocked;
	}

	public String getIcon() {
		return icon;
	}

	public String getTitle() {
		return title;
	}

	public String getState() {
		return state;
	}

	public String getProvider() {
		return provider;
	}

	public String getRedemption() {
		return redemption;
	}

	public int getProgress() {
		return progress;
	}

	public String getProgressDescription() {
		return progressDescription;
	}

	public int getDetail() {
		return detail;
	}

	public int getTarget() {
		return target;
	}

	public List<FoursquareUser> getFriendsHere() {
		return friendsHere;
	}

}
