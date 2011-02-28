package org.richfaces.book.examples.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.xml.bind.annotation.XmlElement;

public class GameDescriptor implements Serializable {
	private String city;
	private String country;
	private String continent;
	private String flagName;
	private int number;
	private seasons season;
	private String note;

	private enum seasons {
		Winter, Summer
	};

	private Calendar fromDate = Calendar.getInstance(Locale.US);
	private Calendar toDate = Calendar.getInstance(Locale.US);

	public GameDescriptor() {

	}

	@XmlElement
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@XmlElement
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@XmlElement
	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	@XmlElement(name = "flag")
	public String getFlagName() {
		return flagName;
	}

	public void setFlagName(String flagName) {
		this.flagName = flagName;
	}

	@XmlElement
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@XmlElement(type=Calendar.class)
	public Calendar getFromDate() {
		return fromDate;
	}

	public void setFromDate(Calendar fromDate) {
		this.fromDate = fromDate;
	}

	@XmlElement(type=Calendar.class)
	public Calendar getToDate() {
		return toDate;
	}

	public void setToDate(Calendar toDate) {
		this.toDate = toDate;
	}

	public void setSeason(seasons season) {
		this.season = season;
	}

	@XmlElement
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@XmlElement
	public seasons getSeason() {
		return season;
	}
}
