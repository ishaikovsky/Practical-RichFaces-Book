package org.richfaces.book.examples.model;

import java.util.List;

public class Entry {
	private String name;

	public Entry(String name) {
		super();
		this.name = name;
	}

	private List<String> properties;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getProperties() {
		return properties;
	}

	public void setProperties(List<String> properties) {
		this.properties = properties;
	}

}
