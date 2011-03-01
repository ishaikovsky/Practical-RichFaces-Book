package org.richfaces.book.examples.util;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class CalendarConverter extends XmlAdapter<String, Calendar> {

	@Override
	public String marshal(Calendar v) throws Exception {
		//TBD
		return null;
	}

	@Override
	public Calendar unmarshal(String v) throws Exception {
		Calendar calendar = Calendar.getInstance(Locale.US);
		calendar.setTime(DateFormat.getDateInstance(DateFormat.SHORT, Locale.US).parse(v));
		return calendar;
	}

}
