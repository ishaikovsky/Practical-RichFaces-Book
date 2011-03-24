package org.richfaces.book.examples;

public class State {

	private String name;
	private String capital;
	private String flagImage;

	// getters and setters

	public State(String name, String capital) {
		this.name = name;
		this.capital = capital;
		this.flagImage = "/images/"
				+ (name.toLowerCase()).replace(" ", "") + ".gif";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getFlagImage() {
		return flagImage;
	}

	public void setFlagImage(String flagImage) {
		this.flagImage = flagImage;
	}

}
