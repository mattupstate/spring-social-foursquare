package org.springframework.social.foursquare.api;

import java.util.List;

public class Category {
	
	private String id;
	private String name;
	private String pluralName;
	private String iconUrl;
	private List<String> parents;
	private boolean primary;
	
	public Category(String id, String name, String pluralName, 
			String iconUrl, List<String> parents, boolean primary) {
		this.id = id;
		this.name = name;
		this.pluralName = pluralName;
		this.iconUrl = iconUrl;
		this.parents = parents;
		this.primary = primary;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPluralName() {
		return pluralName;
	}

	public void setPluralName(String pluralName) {
		this.pluralName = pluralName;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public List<String> getParents() {
		return parents;
	}

	public void setParents(List<String> parents) {
		this.parents = parents;
	}

	public boolean isPrimary() {
		return primary;
	}

	public void setPrimary(boolean primary) {
		this.primary = primary;
	}
	
}
