package org.richfaces.book.examples.model;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.richfaces.book.examples.util.CalendarConverter;

public class GameDescriptor extends BaseDescriptor{
	private String city;
	private String country;
	private String continent;
	private String flagName;
	private int number;
	private seasons season;
	private statuses status = statuses.passed;

	private enum statuses {
		passed, future, canceled
	};

	private enum seasons {
		Winter, Summer
	};

	private Calendar fromDate = new GregorianCalendar(Locale.US);
	private Calendar toDate = new GregorianCalendar(Locale.US);

	public int getYear() {
		return fromDate.get(Calendar.YEAR);
	}

	public String getFrom() {
		if (!status.equals(statuses.canceled)) {
			return fromDate.get(Calendar.DAY_OF_MONTH)
					+ " "
					+ fromDate.getDisplayName(Calendar.MONTH, Calendar.LONG,
							Locale.US);
		} else
			return "";
	}

	public String getTo() {
		if (!status.equals(statuses.canceled)) {
			return toDate.get(Calendar.DAY_OF_MONTH)
					+ " "
					+ toDate.getDisplayName(Calendar.MONTH, Calendar.LONG,
							Locale.US);
		} else
			return "";
	}

	public String getFlagURI() {
		return "/images/flags/" + flagName + ".png";
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

	@XmlElement
	@XmlJavaTypeAdapter(value = CalendarConverter.class)
	public Calendar getFromDate() {
		return fromDate;
	}

	public void setFromDate(Calendar fromDate) {
		this.fromDate = fromDate;
	}

	@XmlElement
	@XmlJavaTypeAdapter(value = CalendarConverter.class)
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
	public statuses getStatus() {
		return status;
	}

	public void setStatus(statuses status) {
		this.status = status;
	}

	@XmlElement
	public seasons getSeason() {
		return season;
	}

}
