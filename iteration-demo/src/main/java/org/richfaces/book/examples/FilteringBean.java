package org.richfaces.book.examples;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.richfaces.book.examples.model.GameDescriptor;
import org.richfaces.model.Filter;

@ManagedBean
@ViewScoped
public class FilteringBean implements Serializable {

	private String cityFilterString;
	private String countryFilterString;
	private int centuryFilterNumber;
	private String continentFilterString="";

	public final static String[] continents = { "Europe", "Asia",
			"North America", "South America", "Oceania" };

	public Filter<GameDescriptor> getCenturyFilter() {
		return new Filter<GameDescriptor>() {
			@Override
			public boolean accept(GameDescriptor t) {
				switch (centuryFilterNumber) {
				case 19:
					return (t.getYear() >= 1800) && (t.getYear() < 1900);
				case 20:
					return (t.getYear() >= 1900) && (t.getYear() < 2000);
				case 21:
					return (t.getYear() >= 2000);
				default:
					return true;
				}
			}
		};
	}

	public void setCountryFilterString(String countryFilterString) {
		this.countryFilterString = countryFilterString;
	}

	public void setCityFilterString(String cityFilterString) {
		this.cityFilterString = cityFilterString;
	}

	public String getCountryFilterString() {
		return countryFilterString;
	}

	public String getCityFilterString() {
		return cityFilterString;
	}

	public int getCenturyFilterNumber() {
		return centuryFilterNumber;
	}

	public void setCenturyFilterNumber(int centuryFilterNumber) {
		this.centuryFilterNumber = centuryFilterNumber;
	}

	public String[] getContinents() {
		return continents;
	}

	public String getContinentFilterString() {
		return continentFilterString;
	}

	public void setContinentFilterString(String continentFilterString) {
		this.continentFilterString = continentFilterString;
	}
}
