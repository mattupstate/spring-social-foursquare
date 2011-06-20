package org.springframework.social.foursquare.api;

import java.util.List;

public class Category {
	
	private String id;
	private String name;
	private String pluralName;
	private String iconUrl;
	private List<String> parents;
	private List<Category> children;
	private boolean primary;
	
	public Category(String id, String name, String pluralName, String iconUrl, boolean primary) {
		this.id = id;
		this.name = name;
		this.pluralName = pluralName;
		this.iconUrl = iconUrl;
		this.primary = primary;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPluralName() {
		return pluralName;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public List<String> getParents() {
		return parents;
	}

	public List<Category> getChildren() {
		return children;
	}
	
	public boolean isPrimary() {
		return primary;
	}
	
}
